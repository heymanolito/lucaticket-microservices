package com.grupo1.lucaticket.ticketpaymentservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Size;

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
    @Size(min=16, max=16)
    private Long numTarjeta;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaCaducidad;
    private Integer CVV;
}
