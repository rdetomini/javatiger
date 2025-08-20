package com.jagrinho.jatiger.domain.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal credito;
    private BigDecimal quantidade_arrecadada;
    @ManyToOne
    private Empresa empresa;
    @OneToMany(mappedBy = "usuario")
    private List<Jogada> jogadas;

    public void adicionarCredito(BigDecimal creditoEntrada) {
        if (credito == null) {
            credito = BigDecimal.ZERO;
        }
        
        credito = credito.add(creditoEntrada);
    }

    public void adicionarQuantidadeArrecadada(BigDecimal creditoEntrada) {
        if (quantidade_arrecadada == null) {
            quantidade_arrecadada = BigDecimal.ZERO;
        }

        quantidade_arrecadada = quantidade_arrecadada.add(creditoEntrada);
    }

    public void diminuirCredito(BigDecimal creditoUtilizado) {
        if (credito == null) {
            credito = BigDecimal.ZERO;
        }

        credito = credito.subtract(creditoUtilizado);
    }
}
