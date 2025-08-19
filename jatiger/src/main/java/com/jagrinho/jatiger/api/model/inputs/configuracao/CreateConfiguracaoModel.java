package com.jagrinho.jatiger.api.model.inputs.configuracao;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateConfiguracaoModel {
    private BigDecimal chance_vitoria;
    private BigDecimal minimo_arrecadacao;
    private BigDecimal porcentagem_repasse;
    private Long empresa_id;
}
