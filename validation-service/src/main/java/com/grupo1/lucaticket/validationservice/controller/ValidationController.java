package com.grupo1.lucaticket.validationservice.controller;

import com.grupo1.lucaticket.validationservice.model.RequestPaymentDto;
import com.grupo1.lucaticket.validationservice.service.ValidationService;
import com.grupo1.lucaticket.validationservice.util.UtilRandom;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ValidationController {

    @PostMapping("/validation")
    public ResponseEntity<?> validarTicket(@RequestBody RequestPaymentDto request) {
        return ResponseEntity.ok(UtilRandom.validarCompra());
    }
}
