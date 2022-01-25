package com.grupo1.lucaticket.dto;

import java.io.Serial;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse implements Serializable {

	// String nombreCompleto, String mail
	@Serial
	private static final long serialVersionUID = 1L;
	private String nombreCompleto;
	private String mail;
}
