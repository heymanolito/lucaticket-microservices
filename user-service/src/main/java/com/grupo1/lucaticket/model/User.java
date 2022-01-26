package com.grupo1.lucaticket.model;

import java.time.LocalDate;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @AllArgsConstructor @NoArgsConstructor class User {

	@Id
	private Long id;
	@NotEmpty
	@Size(min=3)
	private String nombre;
	@NotEmpty
	@Size(min=3)
	private String apellidos;
	@NotEmpty
	@Size(min=3)
	@Email
	private String mail;
	@NotEmpty
	@Size(min=3)
	private String password;
	@NotEmpty
	@Size(min=10, max=10)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaAlta;
	
}
