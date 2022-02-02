package com.grupo1.lucaticket.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDto {

	private String username;

	@NotEmpty(message = "Nombre nulo o vacio")
	@Size(min = 3, message = "Nombre corto, debe tener al menos 3 caracteres")
	@Schema(name = "Nombre completo", description = "Nombre y apellidos del usuario")
	private String fullName;
	@Email(message = "Introduce un email válido")
	@NotEmpty(message = "Email nulo o vacio")
	@Schema(name = "Email", description = "Email del usuario")
	private String email;
	@NotEmpty(message = "Contraseña nula o vacia")
	@Size(min = 3, message = "Contraseña corta, debe tener al menos 3 caracteres")
	@Schema(name = "Contraseña", description = "Contraseña del usuario")
	private String password;
	@NotEmpty(message = "Contraseña nula o vacia")
	@Size(min = 3, message = "Contraseña corta, debe tener al menos 3 caracteres")
	@Schema(name = "Contraseña", description = "Contraseña del usuario")
	private String password2;

	public CreateUserDto(String email) {
		this.email = email;
	}

}
