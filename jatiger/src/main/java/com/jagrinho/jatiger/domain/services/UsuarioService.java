package com.jagrinho.jatiger.domain.services;

import org.springframework.stereotype.Service;

import com.jagrinho.jatiger.domain.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
}
