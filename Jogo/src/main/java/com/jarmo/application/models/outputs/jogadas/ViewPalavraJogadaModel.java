package com.jarmo.application.models.outputs.jogadas;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewPalavraJogadaModel {

    private String palavra;
    private List<ViewJogadaModel> jogada;
}
