package com.zonaro.financasapp.model.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zonaro.financasapp.model.entity.Usuario;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveVerificarExistenciaEmail(){
		// cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@gmail.com").build();
		repository.save(usuario);
		
		// acao
		boolean result = repository.existsByEmail("usuario@gmail.com");
		
		// verificacao
		Assertions.assertThat(result).isTrue();
		
	}

}
