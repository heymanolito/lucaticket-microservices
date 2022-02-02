package com.grupo1.lucaticket.ticketpaymentservice.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestPaymentDto {

    private Long id_user;
    private String nombreEvento;
    private Integer precioEvento;
    private String fullName;
    private Integer numTarjeta;
    private LocalDateTime fechaCaducidad;
    private Integer CVV;
}
