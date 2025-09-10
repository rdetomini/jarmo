package com.jarmo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jarmo.application.models.outputs.configuracaojogadas.ViewConfiguracaoJogadaModel;
import com.jarmo.application.services.ConfiguracaoJogadaApplication;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/configuracaojogada")
public class ConfiguracaoJogadaController {
	
	private final ConfiguracaoJogadaApplication configuracaoJogadaApplication;
	
	@GetMapping
	public List<ViewConfiguracaoJogadaModel> getAll() {
		return configuracaoJogadaApplication.getAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ViewConfiguracaoJogadaModel create() {
		return configuracaoJogadaApplication.create();
	}
	
}
