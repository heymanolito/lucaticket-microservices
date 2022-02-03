package com.grupo1.lucaticket.ticketpaymentservice.controller;

import com.grupo1.lucaticket.ticketpaymentservice.model.PaymentDto;
import com.grupo1.lucaticket.ticketpaymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/payment")
@RestController
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService service;

    @PostMapping("{id}")
    public ResponseEntity<?> comprarTicket(@RequestHeader("Authorization") String token,
                                           @RequestBody PaymentDto request,
                                           @PathVariable int id) {
        PaymentDto paymentDto = service.processPayment(token, request, id);
        // Evento precio y nombre
        String validation = service.requestValidation(paymentDto);
        // Validacion
        return service.pasarelaDePago(paymentDto, validation);
        // Guardamos el ticket en base de datos
    }

}
