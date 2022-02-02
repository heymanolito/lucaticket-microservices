package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.dto.RequestEventDto;
import com.grupo1.lucaticket.dto.ResponseEventDto;
import com.grupo1.lucaticket.model.Ticket;

public interface TicketService {

    ResponseEventDto saveTicket(RequestEventDto ticket);
}
