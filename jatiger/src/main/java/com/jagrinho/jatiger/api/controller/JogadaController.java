package com.jagrinho.jatiger.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jagrinho.jatiger.api.model.inputs.jogada.CreateJogadaModel;
import com.jagrinho.jatiger.api.model.outputs.jogada.ViewJogadaModel;
import com.jagrinho.jatiger.domain.services.JogadaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/jogada")
@AllArgsConstructor
public class JogadaController {
    private final JogadaService jogadaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViewJogadaModel realizarJogada(@RequestBody CreateJogadaModel jogadaModel) {
        jogadaService.realizarJogada(jogadaModel.getCredito(), jogadaModel.getUsuario_id());
        return new ViewJogadaModel();
    }
}
