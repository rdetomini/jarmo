package com.jarmo.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jarmo.application.models.outputs.jogadas.ViewJogadaModel;
import com.jarmo.application.models.outputs.jogadas.ViewPalavraJogadaModel;
import com.jarmo.domain.entities.ConfiguracaoJogada;
import com.jarmo.domain.entities.Jogada;
import com.jarmo.domain.services.ConfiguracaoJogadaService;
import com.jarmo.domain.services.JogadaService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JogadaApplication {

    private final JogadaService jogadaService;
    private final ConfiguracaoJogadaService configuracaoJogadaService;

    @Transactional
    public List<ViewPalavraJogadaModel> jogada(String palavra) {
        Jogada jogada = jogadaService.realizarJogada(palavra);

        if (jogada.getAcertou()) {
            return new ArrayList<ViewPalavraJogadaModel>();
        }
        
        ViewPalavraJogadaModel palavraModel = new ViewPalavraJogadaModel();
        palavraModel.setPalavra(palavra);

        List<ViewJogadaModel> lstJogadaModel = new ArrayList<>();
        ConfiguracaoJogada configuracaoJogada = configuracaoJogadaService.getLastPalavra();
        String[] palavraConfiguracaoSplit = configuracaoJogada.getPalavra().split("");
        String[] palavraSplit = palavra.split("");

        for (int i = 0; i < palavraSplit.length; i++) {
            String letraConfiguracao = palavraConfiguracaoSplit[i];
            String letraPalavra = palavraConfiguracaoSplit[i];
            boolean letraExistePosicaoDiferente = letraPalavra.contains(letraPalavra);
            boolean acertou = letraConfiguracao.equals(letraPalavra);
            ViewJogadaModel jogadaModel = ViewJogadaModel.builder()
                    .letra(letraPalavra)
                    .letra_posicao_diferente(!acertou && letraExistePosicaoDiferente)
                    .acertou(acertou).build();
            lstJogadaModel.add(jogadaModel);
        }
        palavraModel.setJogada(lstJogadaModel);
        return new ArrayList<ViewPalavraJogadaModel>();
    }
}
