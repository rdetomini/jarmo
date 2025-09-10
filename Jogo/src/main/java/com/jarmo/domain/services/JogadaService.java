package com.jarmo.domain.services;

import org.springframework.stereotype.Service;

import com.jarmo.domain.entities.ConfiguracaoJogada;
import com.jarmo.domain.entities.Jogada;
import com.jarmo.domain.repositories.JogadaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JogadaService {

    private final JogadaRepository jogadaRepository;
    private final ConfiguracaoJogadaService configuracaoJogadaService;

    public Jogada create(Jogada jogada) {
        return jogadaRepository.save(jogada);
    }

    public Jogada realizarJogada(String palavra) {
        ConfiguracaoJogada ultimaConfiguracao = configuracaoJogadaService.getLastPalavra();
        Jogada jogada = new Jogada();
        jogada.setAcertou(ultimaConfiguracao.getPalavra().equals(palavra));
        return jogada;
    }
}
