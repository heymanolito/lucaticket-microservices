package com.grupo1.lucaticket.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

public @Data @AllArgsConstructor class Event {

	private Long id;
	private String nombre;
	private String descripcionCorta;
	private String descripcionExtendida;
	private String foto;
	private LocalDate fechaEvento;
	private LocalDate horaEvento;
	private Integer[] rangoPrecios;
	private String politicaAcceso;
	private Recinto recinto;
	
	public Event() {
		
	}
	
	
	

}
