package com.grupo1.lucaticket.ticketpaymentservice.model;


import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDtoNoId {

    private String nombreEvento;
    private Integer precioEvento;
    private String message;
}
