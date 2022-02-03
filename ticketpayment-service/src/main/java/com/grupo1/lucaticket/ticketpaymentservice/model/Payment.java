package com.grupo1.lucaticket.ticketpaymentservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    private Long id_user;
    private String nombreEvento;
    private Integer precioEvento;
    private String fullName;
    private Integer numTarjeta;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaCaducidad;
    private Integer CVV;
}
