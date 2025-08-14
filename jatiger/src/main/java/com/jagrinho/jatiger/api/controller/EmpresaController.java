package com.jagrinho.jatiger.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagrinho.jatiger.domain.services.EmpresaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/empresa")
@AllArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;
}
