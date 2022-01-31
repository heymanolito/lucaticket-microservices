package com.grupo1.lucaticket.ticketpaymentservice.model.dto.adapter;


import com.grupo1.lucaticket.ticketpaymentservice.model.Payment;
import com.grupo1.lucaticket.ticketpaymentservice.model.dto.RequestEventDto;

public class PaymentDtoConverter {

    public Payment convertPayment(Long id, RequestEventDto eventDto) {
        return Payment.builder()
                .id_user(id)
                .nombreEvento(eventDto.getNombreEvento())
                .precioEvento(eventDto.getPrecioEvento()).build();
    }
}
