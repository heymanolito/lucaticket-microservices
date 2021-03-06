package com.grupo1.lucaticket.ticketpaymentservice.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestEventDto {

    private Long id;
    private String nombreEvento;
    private Integer precioEvento;
}
