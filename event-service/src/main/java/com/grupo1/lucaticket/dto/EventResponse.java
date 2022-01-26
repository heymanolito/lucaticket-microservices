package com.grupo1.lucaticket.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class EventResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String nombre;
    private LocalDate fechaEvento;
    private LocalTime horaEvento;
    private String nombreRecinto;
    private String ciudadRecinto;

}
