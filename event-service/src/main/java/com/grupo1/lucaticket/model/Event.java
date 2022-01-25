package com.grupo1.lucaticket.model;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("events")
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
		return "Event[id=" + id +
				", nombre='" + nombre + '\'' +
				", descripcionCorta='" + descripcionCorta + '\'' +
				", descripcionExtendida='" + descripcionExtendida + '\'' +
				", foto='" + foto + '\'' +
				", fechaEvento=" + fechaEvento +
				", horaEvento=" + horaEvento +
				", rangoPrecios=" + Arrays.toString(rangoPrecios) +
				", politicaAcceso='" + politicaAcceso + '\'' +
				", recinto=" + recinto + ']';
	}
}
