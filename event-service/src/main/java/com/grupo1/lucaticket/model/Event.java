package com.grupo1.lucaticket.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;


@Document(collection = "events")
@Schema(name="Evento", description = "Clase evento")
public @Data @NoArgsConstructor @AllArgsConstructor
class Event {
	
	@Transient
	public static final String SEQUENCE_NAME = "events_sequence";
	private int id;
	@Schema(name= "Nombre", description = "Nombre del evento")
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
	private LocalTime horaEvento;
	@Schema(name= "Rango precios", description = "Rango de precios ")
	private Integer[] rangoPrecios = new Integer[2];
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
				", rangoPrecios=" + rangoPrecios +
				", politicaAcceso='" + politicaAcceso + '\'' +
				", recinto=" + recinto + ']';
	}
}
