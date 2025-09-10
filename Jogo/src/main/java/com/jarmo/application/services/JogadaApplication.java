package com.jarmo.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jarmo.application.models.outputs.jogadas.ViewPalavraJogadaModel;
import com.jarmo.domain.services.JogadaService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JogadaApplication {

    private final JogadaService jogadaService;

    @Transactional
    public List<ViewPalavraJogadaModel> jogada(String palavra) {
        jogadaService.realizarJogada(palavra);
        return new ArrayList<ViewPalavraJogadaModel>();
    }
}
