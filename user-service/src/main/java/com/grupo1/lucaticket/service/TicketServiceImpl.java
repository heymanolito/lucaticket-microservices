package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.model.Ticket;
import com.grupo1.lucaticket.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private TicketRepository repository;

    public String saveTicket(Ticket ticket) {
       repository.save(ticket);
       return "vamonos niñooo";
    }
}
