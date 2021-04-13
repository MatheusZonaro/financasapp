package com.zonaro.financasapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zonaro.financasapp.exceptions.RegraNegocioException;
import com.zonaro.financasapp.model.entity.Usuario;
import com.zonaro.financasapp.model.repositories.UsuarioRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveValidarEmail() {
		Assertions.assertDoesNotThrow(() -> {
 
			// cenario
			repository.deleteAll();
 
			// acao
			service.validarEmail("email@gmail.com");
		});
	}
 
	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		Assertions.assertThrows(RegraNegocioException.class, () -> {
			//cenario
			Usuario usuario = Usuario.builder().nome("usuario").email("email@gmail.com").build();		
			repository.save(usuario);
 
			//acao
			service.validarEmail("email@gmail.com");
		});
	}

}
