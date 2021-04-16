package com.zonaro.financasapp.model.repositories;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zonaro.financasapp.model.entity.Usuario;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test") // profile que utiliza h2 como banco de dados
@DataJpaTest // Ao finalizar, deleta base de dados
@AutoConfigureTestDatabase(replace = Replace.NONE) // Não vai substituir a configuração do .properties
class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void deveVerificarExistenciaEmail(){
		// cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@gmail.com").build();
		entityManager.persist(usuario);
		
		// acao
		boolean result = repository.existsByEmail("usuario@gmail.com");
		
		// verificacao
		Assertions.assertThat(result).isTrue();
		
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverCadastroComEmail() {
		
		// acao
		boolean result = repository.existsByEmail("usuario@gmail.com");
		
		// verificacao
		Assertions.assertThat(result).isFalse();
		
	}
	
	@Test
	public void devePersistirUmUsuarioNaBaseDeDados() {
		
		// cenário
		Usuario usuario = criarUsuario();
		
		// acao
		Usuario usuarioSalvo = repository.save(usuario); // Se salvar deve retornar um id
		
		// verificacao
		Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
		
	}
	
	@Test
	public void deveBuscarUsuarioPorEmail() {
		
		// cenário
		Usuario usuario = criarUsuario();
		entityManager.persist(usuario);
		
		// acao
		Optional<Usuario> result = repository.findByEmail("usuario@gmail.com");
		
		// verificacao
		Assertions.assertThat(result.isPresent()).isTrue();
		
	}
	
	@Test
	public void deveRetornarVazioAoBuscarUsuarioPorEmailQuandoNaoExisteNaBase() {
		
		// acao
		Optional<Usuario> result = repository.findByEmail("usuario@gmail.com");
		
		// verificacao
		Assertions.assertThat(result.isPresent()).isFalse();
		
	}
	
	public static Usuario criarUsuario() {
		return Usuario.builder().nome("usuario").email("usuario@gmail.com").senha("senha").build();

	}

}
