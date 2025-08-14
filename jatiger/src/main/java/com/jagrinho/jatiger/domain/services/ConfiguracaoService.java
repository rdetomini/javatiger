package com.jagrinho.jatiger.domain.services;

import org.springframework.stereotype.Service;

import com.jagrinho.jatiger.domain.repositories.ConfiguracaoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfiguracaoService {
    private final ConfiguracaoRepository configuracaoRepository;
}
