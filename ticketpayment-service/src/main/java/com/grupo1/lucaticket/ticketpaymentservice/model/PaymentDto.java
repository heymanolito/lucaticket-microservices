package com.grupo1.lucaticket.ticketpaymentservice.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {

    private Long id_user;
    private String nombreEvento;
    private Integer precioEvento;
    private String fullName;
    @Size(min=16, max=16,message="Pon un numero de targeta valido")
    private Long numTarjeta;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaCaducidad;
    private Integer CVV;
}
