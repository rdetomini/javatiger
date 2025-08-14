package com.jagrinho.jatiger.api.model.outputs.jogada;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewJogadaModel {
    private Long id;
    private BigDecimal credito_utilizado;
    private Boolean jogada_ganha;
}
