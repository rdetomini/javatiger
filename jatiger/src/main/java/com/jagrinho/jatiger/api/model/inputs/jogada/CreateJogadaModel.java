package com.jagrinho.jatiger.api.model.inputs.jogada;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateJogadaModel {
    private Long usuario_id;
    private BigDecimal credito;
}
