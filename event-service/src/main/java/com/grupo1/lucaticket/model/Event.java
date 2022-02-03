package com.grupo1.lucaticket.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "events")
@Schema(name = "Evento", description = "Clase evento")
public @Data
@NoArgsConstructor
@AllArgsConstructor
class Event {

    @Transient
    public static final String SEQUENCE_NAME = "events_sequence";

    @Id
    private int id;
    @NotEmpty(message = "Nombre nulo o vacio")
    @Size(min = 3, message = "Nombre debe tener al menos 3 caracteres")
    @Schema(name = "Nombre", description = "Nombre del evento")
    private String nombre;
    @NotEmpty(message = "Descripcion corta nula o vacia")
    @Size(min = 3, message = "Descripcion corta debe tener al menos 3 caracteres")
    @Schema(name = "Descripcion corta", description = "Datos resumidos ")
    private String descripcionCorta;
    @NotEmpty(message = "Descripcion extendida nula o vacia")
    @Schema(name = "Descripcion extendida", description = "Datos completos ")
    private String descripcionExtendida;
    @Schema(name = "Foto", description = "Foto del evento ")
    private String foto;
    // @NotEmpty
    // @Size(min=10, max=10)
    @Schema(name = "Fecha del Evento", description = "Fecha del evento ")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaEvento;
    // @NotEmpty
    // @Size(min=5, max=5)
    @Schema(name = "Hora de evento", description = "Fecha del evento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime horaEvento;
    @NotEmpty(message = "Rango precio nulo o vacio")
    @Schema(name = "Rango precios", description = "Rango de precios ")
    private Integer[] rangoPrecios = new Integer[2];
    @NotEmpty(message = "Politica de acceso nula o vacia")

    @Size(min = 6, message = "Politica de acceso debe tener al menos 6 caracteres")
    @Schema(name = "Politica de acceso", description = "Politica de acceso ")
    private String politicaAcceso;

    // @NotEmpty
    @Schema(name = "Recinto", description = "Recinto del evento")
    private Recinto recinto;
    @NotEmpty(message = "Genero nulo o vacio")

    @Size(min = 4, message = "Genero debe tener al menos 4 caracteres")
    @Schema(name = "Genero", description = "Genero musical del evento")
    private String genero;

    @Override
    public String toString() {
        return "Event[id=" + id + ", nombre='" + nombre + '\'' + ", descripcionCorta='" + descripcionCorta + '\''
                + ", descripcionExtendida='" + descripcionExtendida + '\'' + ", foto='" + foto + '\'' + ", fechaEvento="
                + fechaEvento + ", horaEvento=" + horaEvento + ", rangoPrecios=" + rangoPrecios + ", politicaAcceso='"
                + politicaAcceso + '\'' + ", recinto=" + recinto + ']' + ", genero=" + genero + ']';
    }
}
