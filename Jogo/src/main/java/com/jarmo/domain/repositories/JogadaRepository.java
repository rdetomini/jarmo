package com.jarmo.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarmo.domain.entities.Jogada;

@Repository
public interface JogadaRepository extends JpaRepository<Jogada, Long>{

}
