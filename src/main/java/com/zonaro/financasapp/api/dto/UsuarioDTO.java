package com.zonaro.financasapp.api.dto;

import com.zonaro.financasapp.model.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
	
	private String nome;
	private String email;
	private String senha;

}
