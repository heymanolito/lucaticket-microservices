package com.grupo1.lucaticket.dto.adapter;

import com.grupo1.lucaticket.dto.PaymentDto;
import com.grupo1.lucaticket.dto.RequestEventDto;

public class PaymentDtoConverter {

    public PaymentDto convertPayment(Long id, RequestEventDto eventDto) {
        return PaymentDto.builder()
                .id_user(id)
                .nombreEvento(eventDto.getNombreEvento())
                .precioEvento(eventDto.getPrecioEvento()).build();
    }
}
