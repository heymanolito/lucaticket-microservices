package com.grupo1.lucaticket.model;

import java.time.LocalDate;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @AllArgsConstructor @NoArgsConstructor class User {

	@Id
	private Long id;
	private String nombre;
	private String apellidos;
	private String mail;
	private String password;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaAlta;
	
}
