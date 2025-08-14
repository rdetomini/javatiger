package com.jagrinho.jatiger.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jagrinho.jatiger.api.model.outputs.configuracao.ViewConfiguracaoModel;
import com.jagrinho.jatiger.domain.services.ConfiguracaoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/configuracao")
@AllArgsConstructor
public class ConfiguracaoController {
    private final ConfiguracaoService configuracaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViewConfiguracaoModel salvar() {
        return new ViewConfiguracaoModel();
    }

    @PutMapping
    public ResponseEntity<ViewConfiguracaoModel> atualizar() {
        return ResponseEntity.ok(new ViewConfiguracaoModel());
    }

    @GetMapping("{id}")
    public ResponseEntity<ViewConfiguracaoModel> getById(@PathVariable long id) {
        return ResponseEntity.ok(new ViewConfiguracaoModel());
    }
}
