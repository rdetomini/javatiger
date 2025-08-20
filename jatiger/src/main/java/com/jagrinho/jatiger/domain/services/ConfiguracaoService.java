package com.jagrinho.jatiger.domain.services;

import org.springframework.stereotype.Service;

import com.jagrinho.jatiger.domain.entities.Configuracao;
import com.jagrinho.jatiger.domain.repositories.ConfiguracaoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfiguracaoService {
    private final ConfiguracaoRepository configuracaoRepository;

    public Configuracao findByEmpresaId(long empresaId) {
        return configuracaoRepository.findByEmpresaId(empresaId);
    }
    @Transactional
    public Configuracao salvar(Configuracao configuracao) {
        return configuracaoRepository.save(configuracao);
    }
}
