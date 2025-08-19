package com.jagrinho.jatiger.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jagrinho.jatiger.domain.entities.Usuario;
import com.jagrinho.jatiger.domain.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }
}
