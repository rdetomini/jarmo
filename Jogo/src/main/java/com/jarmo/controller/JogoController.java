package com.jarmo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jarmo.application.models.inputs.jogadas.CadastrarJogadaModel;
import com.jarmo.application.models.outputs.jogadas.ViewPalavraJogadaModel;
import com.jarmo.application.services.JogadaApplication;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/jogo")
public class JogoController {

    private final JogadaApplication jogadaApplication;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<ViewPalavraJogadaModel> jogada(@RequestBody CadastrarJogadaModel value) {
        System.out.println(value.getPalavra());
        return jogadaApplication.jogada(value.getPalavra());
    }
}
