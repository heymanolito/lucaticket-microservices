package com.grupo1.lucaticket.validationservice.service;


import com.grupo1.lucaticket.validationservice.model.RequestPaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ValidationService {

    @Autowired
    private RestTemplate restTemplate;

    public RequestPaymentDto getEventDetails(int id) {
        return restTemplate.getForObject("http://ticket-payment/" + id, RequestPaymentDto.class);
    }




}
