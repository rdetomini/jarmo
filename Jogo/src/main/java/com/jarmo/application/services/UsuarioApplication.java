package com.jarmo.application.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.jarmo.application.models.inputs.usuarios.AuthModel;
import com.jarmo.application.models.inputs.usuarios.CadastrarUsuarioModel;
import com.jarmo.application.models.outputs.usuarios.ViewUsuarioModel;
import com.jarmo.domain.entities.Usuario;
import com.jarmo.domain.services.UsuarioService;

import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class UsuarioApplication {
	private final UsuarioService usuarioService;
	private final ModelMapper modelMapper;

	public ViewUsuarioModel create(CadastrarUsuarioModel usuarioModel) {
		Usuario usuario = modelMapper.map(usuarioModel, Usuario.class);
		usuario = usuarioService.create(usuario);
		return modelMapper.map(usuario, ViewUsuarioModel.class);
	}

	public String logar(AuthModel authModel) {
		return "token_fake";
	}
	
}
