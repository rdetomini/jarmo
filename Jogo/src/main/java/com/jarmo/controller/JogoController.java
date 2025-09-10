package com.jarmo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jarmo.application.models.outputs.jogadas.ViewPalavraJogadaModel;
import com.jarmo.application.services.JogadaApplication;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/jogo")
public class JogoController {

    private final JogadaApplication jogadaApplication;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<ViewPalavraJogadaModel> jogada(@RequestBody String palavra) {
        return jogadaApplication.jogada(palavra);
    }
}
