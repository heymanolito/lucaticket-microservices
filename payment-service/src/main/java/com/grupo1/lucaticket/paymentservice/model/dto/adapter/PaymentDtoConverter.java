package com.grupo1.lucaticket.paymentservice.model.dto.adapter;

import com.grupo1.lucaticket.paymentservice.model.Payment;
import com.grupo1.lucaticket.paymentservice.model.dto.RequestEventDto;

public class PaymentDtoConverter {

    public Payment convertPayment(Long id, RequestEventDto eventDto) {
        return Payment.builder()
                .id_user(id)
                .nombreEvento(eventDto.getNombreEvento())
                .precioEvento(eventDto.getPrecioEvento()).build();
    }
}
