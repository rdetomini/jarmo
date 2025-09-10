package com.jarmo.domain.repositories;

import java.time.OffsetDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarmo.domain.entities.ConfiguracaoJogada;

@Repository
public interface ConfiguracaoJogadaRepository extends JpaRepository<ConfiguracaoJogada, Long> {
    public ConfiguracaoJogada findByDataCadastroGreaterThanEqual(OffsetDateTime dataCadastro);
}
