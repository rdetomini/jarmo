package com.jarmo.application.models.outputs.jogadas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewJogadaModel {
    private String letra;
    private boolean letra_posicao_diferente;
    private boolean  acertou;
}
