package com.grupo1.lucaticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public @Data @AllArgsConstructor @NoArgsConstructor class Recinto {
	
	private Long id;
	private String nombre;
	private String ciudad;
	private String direccion;
	private Integer aforo;

	@Override
	public String toString() {
		return String.format(
				"Event[id=%s, nombre='%s', ciudad='%s', direccion='%s', aforo='%s'",
				id, nombre, ciudad, direccion, aforo);
	}
}
