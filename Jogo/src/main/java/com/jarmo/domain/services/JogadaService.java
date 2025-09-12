package com.jarmo.domain.services;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.jarmo.domain.entities.ConfiguracaoJogada;
import com.jarmo.domain.entities.Jogada;
import com.jarmo.domain.entities.Usuario;
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
        Jogada jogada = Jogada.builder()
                .acertou(ultimaConfiguracao.getPalavra().equals(palavra))
                .data_tentativa(OffsetDateTime.now())
                .usuario(Usuario.builder().id(1L).build())
                .configuracao_jogada(ultimaConfiguracao)
                .build();



        jogadaRepository.save(jogada);
        return jogada;
    }

}
