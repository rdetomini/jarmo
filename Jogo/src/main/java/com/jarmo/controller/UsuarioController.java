package com.jarmo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarmo.application.models.inputs.usuarios.AuthModel;
import com.jarmo.application.services.UsuarioApplication;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {
	
	private UsuarioApplication usuarioApplication;
	
	@PostMapping("/logar")
	public ResponseEntity<String> auth(@RequestBody AuthModel authModel) {
		String token = usuarioApplication.logar(authModel);
	    return ResponseEntity.ok(token);
	}
}
