package com.jagrinho.jatiger.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jagrinho.jatiger.api.assembler.ModelMapperAssembler;
import com.jagrinho.jatiger.api.model.inputs.usuario.ColocarCredito;
import com.jagrinho.jatiger.api.model.inputs.usuario.CreateUsuarioModel;
import com.jagrinho.jatiger.api.model.outputs.usuario.ViewUsuarioModel;
import com.jagrinho.jatiger.domain.entities.Empresa;
import com.jagrinho.jatiger.domain.entities.Usuario;
import com.jagrinho.jatiger.domain.services.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final ModelMapperAssembler modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViewUsuarioModel salvar(@RequestBody CreateUsuarioModel usuarioModel) {
        Usuario usuario = modelMapper.converter(usuarioModel, Usuario.class);
        Empresa empresa = new Empresa();
        empresa.setId(usuarioModel.getEmpresa_id());
        usuario.setEmpresa(empresa);
        usuarioService.salvar(usuario);
        return modelMapper.converter(usuario, ViewUsuarioModel.class);
    }

    @PutMapping
    public ResponseEntity<ViewUsuarioModel> colocarCredito(@RequestBody ColocarCredito colocarCredito) {
        Usuario usuario = usuarioService.findById(colocarCredito.getUsuario_id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.adicionarCredito(colocarCredito.getCredito());

        usuarioService.salvar(usuario);

        return ResponseEntity.ok(modelMapper.converter(usuario, ViewUsuarioModel.class));
    }

    @GetMapping
    public List<ViewUsuarioModel> getAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        return modelMapper.converter(usuarios, ViewUsuarioModel.class);
    }
}
