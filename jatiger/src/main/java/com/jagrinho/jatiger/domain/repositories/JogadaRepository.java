package com.jagrinho.jatiger.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jagrinho.jatiger.domain.entities.Jogada;

@Repository
public interface JogadaRepository extends JpaRepository<Jogada, Long>{

}
