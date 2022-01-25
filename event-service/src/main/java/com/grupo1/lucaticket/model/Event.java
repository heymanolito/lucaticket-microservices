package com.grupo1.lucaticket.model;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("events")
@Schema(name="Evento", description = "Clase evento")

public @Data @NoArgsConstructor @AllArgsConstructor class Event {
	
	@Id
	private Long id;
	@Schema(name= "Nombre", description = "Nombre dek evento")
	private String nombre;
	@Schema(name= "Descripcion corta", description = "Datos resumidos ")
	private String descripcionCorta;
	@Schema(name= "Descripcion extendida", description = "Datos completos ")
	private String descripcionExtendida;
	@Schema(name= "Foto", description = "Foto del evento ")
	private String foto;
	@Schema(name= "Fecha del Evento", description = "Fecha del evento ")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaEvento;
	@Schema(name= "Hora de evento", description = "Fecha del evento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalDate horaEvento;
	@Schema(name= "Rango precios", description = "Rango de precios ")
	private Integer[] rangoPrecios;
	@Schema(name= "Politica de acceso", description = "Politica de acceso ")
	private String politicaAcceso;
	@Schema(name= "Recinto", description = "Recinto del evento")
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
