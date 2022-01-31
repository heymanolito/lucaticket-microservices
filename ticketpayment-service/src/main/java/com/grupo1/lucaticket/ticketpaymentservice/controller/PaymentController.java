package com.grupo1.lucaticket.ticketpaymentservice.controller;

import com.grupo1.lucaticket.ticketpaymentservice.model.Payment;
import com.grupo1.lucaticket.ticketpaymentservice.model.dto.RequestEventDto;
import com.grupo1.lucaticket.ticketpaymentservice.service.PaymentService;
import com.grupo1.lucaticket.ticketpaymentservice.util.TokenUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.grupo1.lucaticket.ticketpaymentservice.util.TokenUtil.getBearerTokenHeader;


@RestController
@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private TokenUtil tokenProvider;

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
