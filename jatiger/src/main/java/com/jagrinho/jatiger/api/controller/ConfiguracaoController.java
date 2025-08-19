package com.jagrinho.jatiger.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jagrinho.jatiger.api.assembler.ModelMapperAssembler;
import com.jagrinho.jatiger.api.model.inputs.configuracao.CreateConfiguracaoModel;
import com.jagrinho.jatiger.api.model.inputs.configuracao.UpdateConfiguracaoModel;
import com.jagrinho.jatiger.api.model.outputs.configuracao.ViewConfiguracaoModel;
import com.jagrinho.jatiger.domain.entities.Configuracao;
import com.jagrinho.jatiger.domain.entities.Empresa;
import com.jagrinho.jatiger.domain.services.ConfiguracaoService;
import com.jagrinho.jatiger.domain.services.EmpresaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/configuracao")
@AllArgsConstructor
public class ConfiguracaoController {

    private final ConfiguracaoService configuracaoService;
    private final EmpresaService empresaService;
    private final ModelMapperAssembler modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViewConfiguracaoModel salvar(@RequestBody CreateConfiguracaoModel configuracaoModel) {
        Configuracao configuracao = modelMapper.converter(configuracaoModel, Configuracao.class);
        Empresa empresa = new Empresa();
        empresa.setId(configuracaoModel.getEmpresa_id());
        configuracao.setEmpresa(empresa);
        configuracaoService.salvar(configuracao);

        return modelMapper.converter(configuracao, ViewConfiguracaoModel.class);
    }

    @PutMapping
    public ResponseEntity<ViewConfiguracaoModel> atualizar(@RequestBody UpdateConfiguracaoModel configuracaoModel) {
        Configuracao configuracao = modelMapper.converter(configuracaoModel, Configuracao.class);

          Empresa empresa = empresaService.findById(configuracaoModel.getEmpresa_id())
        .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        configuracao.setEmpresa(empresa);
        configuracaoService.salvar(configuracao);
        return ResponseEntity.ok(modelMapper.converter(configuracao, ViewConfiguracaoModel.class));
    }

    @GetMapping("/{empresaId}")
    public ResponseEntity<List<ViewConfiguracaoModel>> findByEmpresaId(@PathVariable long empresaId) {
        List<Configuracao> configuracoes = configuracaoService.findByEmpresaId(empresaId);
        List<ViewConfiguracaoModel> configuracoesModel = modelMapper.converter(configuracoes, ViewConfiguracaoModel.class);
        return ResponseEntity.ok(configuracoesModel);
    }

}
