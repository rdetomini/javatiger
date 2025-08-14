package com.jagrinho.jatiger.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagrinho.jatiger.domain.services.ConfiguracaoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/configuracao")
@AllArgsConstructor
public class ConfiguracaoController {
    private final ConfiguracaoService configuracaoService;
}
