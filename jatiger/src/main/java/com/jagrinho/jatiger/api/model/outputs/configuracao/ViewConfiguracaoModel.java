package com.jagrinho.jatiger.api.model.outputs.configuracao;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewConfiguracaoModel {
    private Long id;
    private BigDecimal chance_vitoria;
    private BigDecimal minimo_arrecadacao;
    private BigDecimal porcentagem_repasse;
}
