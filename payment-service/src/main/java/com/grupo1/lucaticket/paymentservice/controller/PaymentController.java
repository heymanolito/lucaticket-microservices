package com.grupo1.lucaticket.paymentservice.controller;

import com.grupo1.lucaticket.paymentservice.model.Payment;
import com.grupo1.lucaticket.paymentservice.model.dto.RequestEventDto;
import com.grupo1.lucaticket.paymentservice.service.PaymentService;
import com.grupo1.lucaticket.paymentservice.util.TokenUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

import static com.grupo1.lucaticket.paymentservice.util.TokenUtil.TOKEN_HEADER;
import static com.grupo1.lucaticket.paymentservice.util.TokenUtil.getBearerTokenHeader;


@RestController
@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private TokenUtil tokenProvider;
    @Autowired
    private PaymentService service;

    @PostMapping("{id}")
    public ResponseEntity<?> comprarTicket(@RequestBody Payment payment, @PathVariable int id) {
        //EventDto con rest template - >
        RequestEventDto event = service.getEventDetails(id);
        Long userId = tokenProvider.getUserIdFromJWT(getBearerTokenHeader()); //Obtenemos el ID del usuario
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
