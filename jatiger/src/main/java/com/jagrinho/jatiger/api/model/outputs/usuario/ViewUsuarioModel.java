package com.jagrinho.jatiger.api.model.outputs.usuario;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewUsuarioModel {
    private Long id;
    private BigDecimal credito;
    private BigDecimal quantidade_arrecadada;
}
