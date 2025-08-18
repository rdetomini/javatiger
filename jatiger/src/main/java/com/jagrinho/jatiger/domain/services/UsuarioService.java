package com.jagrinho.jatiger.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jagrinho.jatiger.domain.entities.Usuario;
import com.jagrinho.jatiger.domain.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
