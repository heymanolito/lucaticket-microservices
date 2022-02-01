package com.grupo1.lucaticket.ticketpaymentservice.service;

import com.grupo1.lucaticket.ticketpaymentservice.model.dto.RequestEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    public RequestEventDto getEventDetails(int id) {
        return restTemplate.getForObject("http://localhost:8091/events/" + id, RequestEventDto.class);
    }
}
