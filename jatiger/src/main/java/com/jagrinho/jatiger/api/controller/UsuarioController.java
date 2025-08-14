package com.jagrinho.jatiger.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jagrinho.jatiger.api.model.outputs.usuario.ViewUsuarioModel;
import com.jagrinho.jatiger.domain.services.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViewUsuarioModel salvar() {
        return new ViewUsuarioModel();
    }

    @GetMapping
    public List<ViewUsuarioModel> getAll() {
        return new ArrayList<ViewUsuarioModel>();
    }
}
