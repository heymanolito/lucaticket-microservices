package com.grupo1.lucaticket.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="Evento", description = "Clase evento")
public @Data @AllArgsConstructor @NoArgsConstructor class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Schema(name= "Nombre", description = "Nombre del usuario")
	private String nombre;
	@Schema(name= "Apellidos", description = "Apellidos del usuario")
	private String apellidos;
	@Schema(name= "Email", description = "Email del usuario")
	private String mail;
	@Size(min = 6, max = 30)
	@Schema(name= "Password", description = "Password del usuario")
	private String password;
	@Schema(name= "Fecha de alta", description = "Fecha de alta del usuario")
	private LocalDate fechaAlta;
	
}
