package com.jarmo.domain.services;

import org.springframework.stereotype.Service;

import com.jarmo.domain.entities.Usuario;
import com.jarmo.domain.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {
	private UsuarioRepository usuarioRepository;
	public Usuario create(Usuario usuario) {
		return usuarioRepository.save(usuario);		
	}
}
