package com.jagrinho.jatiger.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagrinho.jatiger.domain.services.JogadaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/jogada")
@AllArgsConstructor
public class JogadaController {
    private final JogadaService jogadaService;
}
