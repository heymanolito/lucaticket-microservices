package com.grupo1.lucaticket.ticketpaymentservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    private Long id_user;
    private Long id_event;
    private String nombreEvento;
    private Integer precioEvento;
    private String fullName;
    private Integer numTarjeta;
    private LocalDateTime fechaCaducidad;
    private Integer CVV;
}
