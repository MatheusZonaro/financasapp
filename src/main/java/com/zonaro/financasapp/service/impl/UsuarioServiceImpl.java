package com.zonaro.financasapp.service.impl;

import com.zonaro.financasapp.model.entity.Usuario;
import com.zonaro.financasapp.model.repositories.UsuarioRepository;
import com.zonaro.financasapp.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository repository; // Para acessar a base de dados
		
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validarEmail(String email) {
		// TODO Auto-generated method stub
		
	}

}
