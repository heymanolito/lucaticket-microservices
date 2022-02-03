package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.dto.RequestEventDto;

public interface TicketService {

    RequestEventDto saveTicket(RequestEventDto ticket);
}
