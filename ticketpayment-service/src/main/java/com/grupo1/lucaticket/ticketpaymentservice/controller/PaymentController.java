package com.grupo1.lucaticket.ticketpaymentservice.controller;

import com.grupo1.lucaticket.ticketpaymentservice.model.Payment;
import com.grupo1.lucaticket.ticketpaymentservice.model.dto.RequestEventDto;
import com.grupo1.lucaticket.ticketpaymentservice.service.PaymentService;
import com.grupo1.lucaticket.ticketpaymentservice.util.TokenUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.grupo1.lucaticket.ticketpaymentservice.util.TokenUtil.getBearerTokenHeader;



@RequiredArgsConstructor
@RequestMapping("/payment")
@RestController
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService service;

    @PostMapping("{id}")
    public ResponseEntity<?> comprarTicket(@RequestHeader("Authorization") String token, @RequestBody Payment payment, @PathVariable int id) {
        //EventDto con rest template - >
        RequestEventDto event = service.getEventDetails(id);
        log.info(token);
        Long userId = TokenUtil.getUserIdFromJWT(token); //Obtenemos el ID del usuario
        // Recoge el POST del usuario
        Payment paymentDto = Payment.builder()
                .id_user(userId)
                .nombreEvento(event.getNombreEvento())
                .precioEvento(event.getPrecioEvento())
                .fullName(payment.getFullName())
                .fechaCaducidad(payment.getFechaCaducidad())
                .numTarjeta(payment.getNumTarjeta())
                .CVV(payment.getCVV()).build();
        return ResponseEntity.ok(paymentDto);
    }



}
