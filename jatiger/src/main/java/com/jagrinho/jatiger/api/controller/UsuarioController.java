package com.jagrinho.jatiger.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagrinho.jatiger.domain.services.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
}
