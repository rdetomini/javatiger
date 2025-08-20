package com.jagrinho.jatiger.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jagrinho.jatiger.domain.entities.Configuracao;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long>{
    public Configuracao findByEmpresaId(long empresaId);
}
