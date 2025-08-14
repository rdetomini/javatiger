package com.jagrinho.jatiger.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagrinho.jatiger.api.model.outputs.empresa.ViewEmpresaModel;
import com.jagrinho.jatiger.domain.services.EmpresaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/empresa")
@AllArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping
    public ViewEmpresaModel cadastrar() {
        return new ViewEmpresaModel();
    }

    @GetMapping
    public List<ViewEmpresaModel> getAll() {
        return new ArrayList<ViewEmpresaModel>();
    }
}
