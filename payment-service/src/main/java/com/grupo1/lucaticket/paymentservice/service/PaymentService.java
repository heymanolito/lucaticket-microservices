package com.grupo1.lucaticket.paymentservice.service;

import com.grupo1.lucaticket.paymentservice.model.dto.RequestEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    public RequestEventDto getEventDetails(int id) {
        return restTemplate.getForObject("http://localhost:8091/events/" + id, RequestEventDto.class);
    }
}
