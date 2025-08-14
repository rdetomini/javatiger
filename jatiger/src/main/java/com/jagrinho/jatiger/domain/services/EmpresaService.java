package com.jagrinho.jatiger.domain.services;

import org.springframework.stereotype.Service;

import com.jagrinho.jatiger.domain.repositories.EmpresaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
}   
