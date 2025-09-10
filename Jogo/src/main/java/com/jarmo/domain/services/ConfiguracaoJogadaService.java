package com.jarmo.domain.services;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarmo.domain.entities.ConfiguracaoJogada;
import com.jarmo.domain.repositories.ConfiguracaoJogadaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfiguracaoJogadaService {

    private final ConfiguracaoJogadaRepository configuracaoJogadaRepository;

    public List<ConfiguracaoJogada> getAll() {
        return configuracaoJogadaRepository.findAll();
    }

    public ConfiguracaoJogada create(ConfiguracaoJogada configuracaoJogada) {
        return configuracaoJogadaRepository.save(configuracaoJogada);
    }

    public ConfiguracaoJogada getLastPalavra() {
		OffsetDateTime inicioDoDiaUTC = LocalDate.now()
											.atStartOfDay()
											.atOffset(ZoneOffset.UTC);

		return configuracaoJogadaRepository.findByDataCadastroGreaterThanEqual(inicioDoDiaUTC);
    }
}
