package com.jarmo.infra.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jarmo.application.models.inputs.jogadas.CadastrarJogadaModel;
import com.jarmo.application.models.inputs.usuarios.AuthModel;
import com.jarmo.application.models.inputs.usuarios.CadastrarUsuarioModel;
import com.jarmo.application.models.outputs.configuracaojogadas.ViewConfiguracaoJogadaModel;
import com.jarmo.application.models.outputs.jogadas.ViewJogadaModel;
import com.jarmo.application.models.outputs.usuarios.ViewUsuarioModel;
import com.jarmo.domain.entities.ConfiguracaoJogada;
import com.jarmo.domain.entities.Jogada;
import com.jarmo.domain.entities.Usuario;


@Configuration
public class ModelMapperConfig {
	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.createTypeMap(AuthModel.class, Usuario.class);
		modelMapper.createTypeMap(CadastrarUsuarioModel.class, Usuario.class);
		modelMapper.createTypeMap(Usuario.class, ViewUsuarioModel.class);
		modelMapper.createTypeMap(ConfiguracaoJogada.class, ViewConfiguracaoJogadaModel.class);
		modelMapper.createTypeMap(Jogada.class, ViewJogadaModel.class);
		modelMapper.createTypeMap(CadastrarJogadaModel.class, Jogada.class);
		return modelMapper;
	}
}
