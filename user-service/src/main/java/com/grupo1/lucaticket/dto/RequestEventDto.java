package com.grupo1.lucaticket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestEventDto {

    private String nombreEvento;
    private Integer precioEvento;
}
