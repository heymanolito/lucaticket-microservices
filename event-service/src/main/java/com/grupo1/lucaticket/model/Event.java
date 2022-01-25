package com.grupo1.lucaticket.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(name="Perro", description = "Clase Perro")
public @Data @AllArgsConstructor class Event {
	
	private Long id;
	@Schema(name= "Nombre", description = "Nombre dek evento")
	private String nombre;
	@Schema(name= "Descripcion corta", description = "Datos resumidos ")
	private String descripcionCorta;
	@Schema(name= "Descripcion extendida", description = "Datos completos ")
	private String descripcionExtendida;
	@Schema(name= "Foto", description = "Foto del evento ")
	private String foto;
	@Schema(name= "Fecha Evento", description = "Datos resumidos ")
	private LocalDate fechaEvento;
	private LocalDate horaEvento;
	private Integer[] rangoPrecios;
	private String politicaAcceso;
	private Recinto recinto;
	
	public Event() {
		
	}

}
