package com.grupo1.lucaticket.model;

import java.time.LocalDate;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Schema(name="Usuario", description = "Clase usuario")
public @Data @AllArgsConstructor @NoArgsConstructor class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(name= "Nombre", description = "Nombre del usuario")
	private Long id;
	@NotEmpty
	@Size(min=3)
	@Schema(name= "Nombre", description = "Nombre del usuario")
	private String nombre;
	@NotEmpty
	@Size(min=3)
	@Schema(name= "Apellidos", description = "Apellidos del usuario")
	private String apellidos;
	@NotEmpty
	@Size(min=3)
	@Email
	@Schema(name= "Email", description = "Email del usuario")
	private String mail;
	@NotEmpty
	@Size(min=3)
	@Schema(name= "Password", description = "Password del usuario")
	private String password;
	@NotEmpty
	@Size(min=10, max=10)
	@Schema(name= "Fecha de alta", description = "Fecha de alta del usuario")
	@Column(name="fecha_alta")
	private String fechaAlta;
	
}
