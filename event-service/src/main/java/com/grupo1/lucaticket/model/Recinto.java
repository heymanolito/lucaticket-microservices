package com.grupo1.lucaticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;

@Document
@Schema(name="Recinto", description = "Clase recinto")
public @Data @AllArgsConstructor @NoArgsConstructor class Recinto {
	
	private Long id;
	@Schema(name= "Nombre", description = "Nombre del recinto ")
	private String nombre;
	@Schema(name= "Foto", description = "Foto del recinto ")
	private String ciudad;
	@Schema(name= "Direccion", description = "Direccion del recinto ")
	private String direccion;
	@Schema(name= "Aforo", description = "Aforo del recinto")
	private Integer aforo;

	@Override
	public String toString() {
		return String.format(
				"Event[id=%s, nombre='%s', ciudad='%s', direccion='%s', aforo='%s'",
				id, nombre, ciudad, direccion, aforo);
	}
}
