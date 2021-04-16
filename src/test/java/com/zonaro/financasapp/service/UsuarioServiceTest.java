package com.zonaro.financasapp.service;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zonaro.financasapp.exceptions.RegraNegocioException;
import com.zonaro.financasapp.model.entity.Usuario;
import com.zonaro.financasapp.model.repositories.UsuarioRepository;
import com.zonaro.financasapp.service.impl.UsuarioServiceImpl;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {
	
	UsuarioService service;
	UsuarioRepository repository;
	
	@Before
	public void SetUp() {
		repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioServiceImpl(repository);
	}
	
	@Test
	public void deveValidarEmail() {
		Assertions.assertDoesNotThrow(() -> {
 
			// cenario
			Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);
 
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
