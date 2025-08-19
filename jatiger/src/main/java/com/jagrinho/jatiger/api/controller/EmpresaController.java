package com.jagrinho.jatiger.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jagrinho.jatiger.api.assembler.ModelMapperAssembler;
import com.jagrinho.jatiger.api.model.inputs.empresa.CreateEmpresaModel;
import com.jagrinho.jatiger.api.model.outputs.empresa.ViewEmpresaModel;
import com.jagrinho.jatiger.domain.entities.Empresa;
import com.jagrinho.jatiger.domain.services.EmpresaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/empresa")
@AllArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;
    private final ModelMapperAssembler modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViewEmpresaModel cadastrar(@RequestBody CreateEmpresaModel empresaModel) {
        Empresa empresa = modelMapper.converter(empresaModel, Empresa.class);
        empresaService.salvar(empresa);
        return modelMapper.converter(empresa, ViewEmpresaModel.class);
    }

    @GetMapping
    public List<ViewEmpresaModel> getAll() {
        List<Empresa> empresas = empresaService.findAll();

        return modelMapper.converter(empresas, ViewEmpresaModel.class);
    }
}
