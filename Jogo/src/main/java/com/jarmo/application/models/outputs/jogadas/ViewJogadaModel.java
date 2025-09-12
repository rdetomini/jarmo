package com.jarmo.application.models.outputs.jogadas;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ViewJogadaModel {
    private String letra;
    private boolean letra_posicao_diferente;
    private boolean  acertou;

}
