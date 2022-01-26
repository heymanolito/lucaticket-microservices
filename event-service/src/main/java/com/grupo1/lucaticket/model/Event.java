package com.grupo1.lucaticket.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "events")
@Schema(name="Evento", description = "Clase evento")
public @Data @NoArgsConstructor @AllArgsConstructor class Event {
	
	@Transient
	public static final String SEQUENCE_NAME = "events_sequence";
	
	@Id
	private Long id;
	@NotEmpty
	@Size(min=3)
	@Schema(name= "Nombre", description = "Nombre del evento")
	private String nombre;
	@NotEmpty
	@Size(min=3)
	@Schema(name= "Descripcion corta", description = "Datos resumidos ")
	private String descripcionCorta;
	@NotEmpty
	@Size(min=3)
	@Schema(name= "Descripcion extendida", description = "Datos completos ")
	private String descripcionExtendida;
	@Schema(name= "Foto", description = "Foto del evento ")
	private String foto;
	@NotEmpty
	@Size(min=10, max=10)
	@Schema(name= "Fecha del Evento", description = "Fecha del evento ")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaEvento;
	@NotEmpty
	@Size(min=5, max=5)
	@Schema(name= "Hora de evento", description = "Fecha del evento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime horaEvento;
	@NotEmpty
	@Schema(name= "Rango precios", description = "Rango de precios ")
	private Integer[] rangoPrecios = new Integer[2];
	@NotEmpty
	@Size(min=6)
	@Schema(name= "Politica de acceso", description = "Politica de acceso ")
	private String politicaAcceso;
	@NotEmpty
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
