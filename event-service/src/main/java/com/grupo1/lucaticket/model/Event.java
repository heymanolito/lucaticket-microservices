package com.grupo1.lucaticket.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor @AllArgsConstructor class Event {
	
	@Id
	private Long id;
	private String nombre;
	private String descripcionCorta;
	private String descripcionExtendida;
	private String foto;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaEvento;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalDate horaEvento;
	private Integer[] rangoPrecios;
	private String politicaAcceso;
	private Recinto recinto;
	
	@Override
	public String toString() {
		return String.format(
				"Event[id=%s, nombre='%s', descripcionCorta='%s', descripcionExtendida='%s', foto='%s', fechaEvento='%s', horaEvento='%s', rangoPrecios='%s', politicaAcceso='%s', recinto='$s' ",
				id, nombre, descripcionCorta, descripcionExtendida, foto, fechaEvento, horaEvento, rangoPrecios, politicaAcceso, recinto);			
	}
}
