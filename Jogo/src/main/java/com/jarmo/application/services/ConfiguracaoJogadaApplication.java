package com.jarmo.application.services;

import java.time.OffsetDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.jarmo.application.models.outputs.configuracaojogadas.ViewConfiguracaoJogadaModel;
import com.jarmo.domain.entities.ConfiguracaoJogada;
import com.jarmo.domain.services.ConfiguracaoJogadaService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ConfiguracaoJogadaApplication {
	private final ConfiguracaoJogadaService configuracaoJogadaService;
	private final ModelMapper modelMapper;

	public List<ViewConfiguracaoJogadaModel> getAll() {
		List<ConfiguracaoJogada> configuracoes = configuracaoJogadaService.getAll();
		List<ViewConfiguracaoJogadaModel> lista = configuracoes.stream()
				.map(c -> modelMapper.map(c, ViewConfiguracaoJogadaModel.class)).toList();

		return lista;
	}

	public ViewConfiguracaoJogadaModel create() {
		ConfiguracaoJogada configuracao = new ConfiguracaoJogada();
		configuracao.gerarPalavra();
		configuracao.setDataCadastro(OffsetDateTime.now());
		configuracaoJogadaService.create(configuracao);

		return modelMapper.map(configuracao, ViewConfiguracaoJogadaModel.class);
	}

	public ViewConfiguracaoJogadaModel getLastPalavra() {
		ConfiguracaoJogada configuracao = configuracaoJogadaService.getLastPalavra();

		return modelMapper.map(configuracao, ViewConfiguracaoJogadaModel.class);
	}
}
