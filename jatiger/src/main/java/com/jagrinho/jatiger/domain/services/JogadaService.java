package com.jagrinho.jatiger.domain.services;

import org.springframework.stereotype.Service;

import com.jagrinho.jatiger.domain.repositories.JogadaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JogadaService {
    private final JogadaRepository jogadaRepository;
}
