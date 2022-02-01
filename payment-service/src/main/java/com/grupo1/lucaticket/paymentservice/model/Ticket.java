package com.grupo1.lucaticket.paymentservice.model;

import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    private String nombreEvento;
    private Integer precioEvento;
    private String message;

}
