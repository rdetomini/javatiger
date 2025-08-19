package com.jagrinho.jatiger.domain.services;

import java.util.List;
import java.util.Optional;

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
    public Optional<Empresa> findById(long id) {
        return empresaRepository.findById(id);
    } 

    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}   
