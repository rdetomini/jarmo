package com.jarmo.application.models.inputs.usuarios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarUsuarioModel {
	@NotNull
	@NotBlank
	private String nome;
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	private String senha;
}
