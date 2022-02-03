package com.grupo1.lucaticket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseEventDto {

    private String nombreEvento;
    private int precioEvento;
    private String message;
}
