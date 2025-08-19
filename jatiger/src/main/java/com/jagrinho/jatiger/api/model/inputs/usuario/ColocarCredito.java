package com.jagrinho.jatiger.api.model.inputs.usuario;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColocarCredito {
    public Long empresa_id;
    public Long usuario_id;
    public BigDecimal credito;
}
