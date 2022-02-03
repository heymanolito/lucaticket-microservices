package com.grupo1.lucaticket.controller;

import com.grupo1.lucaticket.dto.RequestEventDto;
import com.grupo1.lucaticket.service.TicketService;
import com.grupo1.lucaticket.service.TicketServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    private static final Logger log = LoggerFactory.getLogger(TicketController.class);

    @PostMapping("/save")
    public ResponseEntity<?> saveTicket(@RequestBody RequestEventDto request){
         log.info("--- [CONTROLLER] - Request " + request);

        return ResponseEntity.ok(service.saveTicket(request));
    }
}
