package com.zonaro.financasapp.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zonaro.financasapp.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { // Interface que já extende JpaRepository, com crud, abaixo apenas metodos adicionais
	
	boolean existsByEmail(String email);
	
	Optional<Usuario> findByEmail(String email);
	
}
