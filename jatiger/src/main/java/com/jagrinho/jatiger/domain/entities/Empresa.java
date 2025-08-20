package com.jagrinho.jatiger.domain.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empresas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empresa {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal arrecadado;
    @OneToOne(mappedBy = "empresa")
    private Configuracao configuracao;
    @OneToMany(mappedBy = "empresa")
    private List<Usuario> usuarios;

    public void adicionarQuantidadeArrecadada(BigDecimal credito) {
        if (arrecadado == null) {
            arrecadado = BigDecimal.ZERO;
        }

        arrecadado = arrecadado.add(credito);
    }

    public void diminuirArrecadacao(BigDecimal creditoUtilizado) {
        if (arrecadado == null) {
            arrecadado = BigDecimal.ZERO;
        }

        arrecadado = arrecadado.subtract(creditoUtilizado);
    }
}
