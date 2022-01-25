package com.grupo1.lucaticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @AllArgsConstructor @NoArgsConstructor class Recinto {
	
	private Long id;
	private String nombre;
	private String ciudad;
	private String direccion;
	private Integer aforo;
	
}
