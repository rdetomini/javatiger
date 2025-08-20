package com.jagrinho.jatiger.domain.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.jagrinho.jatiger.domain.entities.Configuracao;
import com.jagrinho.jatiger.domain.entities.Empresa;
import com.jagrinho.jatiger.domain.entities.Jogada;
import com.jagrinho.jatiger.domain.entities.Usuario;
import com.jagrinho.jatiger.domain.repositories.JogadaRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JogadaService {

    private final JogadaRepository jogadaRepository;
    private final ConfiguracaoService configuracaoService;
    private final EmpresaService empresaService;
    private final UsuarioService usuarioService;

    @Transactional
    public Jogada realizarJogada(BigDecimal credito_utilizado, Long usuario_id) {
        Usuario usuario = usuarioService.findById(usuario_id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Empresa empresa = empresaService.findById(usuario.getEmpresa().getId())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        Configuracao configuracao = configuracaoService.findByEmpresaId(empresa.getId());
        // Verifica se o usuário tem creditos suficiente para realizar a jogada
        if (usuario.getCredito() == null || usuario.getCredito().compareTo(credito_utilizado) < 0) {
            new RuntimeException("Usuário não tem créditos suficientes");
            return new Jogada();
        }

        Jogada jogada = new Jogada();
        jogada.setJogada_ganha(false);
        jogada.setCredito_utilizado(credito_utilizado);
        jogada.setUsuario(usuario);

        // Verifica se atingiu o mínimo arrecadado configurado
        // Caso tenha atingido o minimo tambem deve verificar se ganhou
        if (usuario.getQuantidade_arrecadada() != null && usuario.getQuantidade_arrecadada().compareTo(configuracao.getMinimo_arrecadacao()) >= 0 && jogada.realizarJogada(configuracao.getChance_vitoria())) {
            BigDecimal quantidadeArrecadadaUsuario = usuario.getQuantidade_arrecadada();
            BigDecimal cem = new BigDecimal("100");
            BigDecimal porcentagem = configuracao.getPorcentagem_repasse().divide(cem, 10, RoundingMode.HALF_UP);

            BigDecimal creditoUsuario = quantidadeArrecadadaUsuario.multiply(porcentagem);
            usuario.setQuantidade_arrecadada(BigDecimal.ZERO);
            usuario.adicionarCredito(creditoUsuario);
            empresa.diminuirArrecadacao(creditoUsuario);
            jogada.setJogada_ganha(true);
        } else {
            usuario.adicionarQuantidadeArrecadada(credito_utilizado);
            usuario.diminuirCredito(credito_utilizado);
            empresa.adicionarQuantidadeArrecadada(credito_utilizado);
        }

        jogadaRepository.save(jogada);
        return jogada;
    }
}
