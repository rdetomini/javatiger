package com.jagrinho.jatiger.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jagrinho.jatiger.domain.entities.Empresa;
import com.jagrinho.jatiger.domain.repositories.EmpresaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    } 

    public Empresa create(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}   
