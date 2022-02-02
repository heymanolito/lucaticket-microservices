package com.grupo1.lucaticket.controller;

import com.grupo1.lucaticket.dto.ResponseTicketDto;
import com.grupo1.lucaticket.model.Ticket;
import com.grupo1.lucaticket.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private TicketService service;

    @PostMapping("/save")
    public ResponseEntity<?> saveTicket(@RequestBody Ticket ticket){
        return ResponseEntity.ok(service.saveTicket(ticket));
    }
}
