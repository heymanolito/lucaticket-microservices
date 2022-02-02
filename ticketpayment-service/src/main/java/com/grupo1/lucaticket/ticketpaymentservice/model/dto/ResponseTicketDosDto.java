package com.grupo1.lucaticket.ticketpaymentservice.model.dto;


import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseTicketDosDto {

    private String nombreEvento;
    private Integer precioEvento;
    private String message;

}