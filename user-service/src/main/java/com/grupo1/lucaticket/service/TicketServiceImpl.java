package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.controller.AuthenticationController;
import com.grupo1.lucaticket.dto.RequestEventDto;
import com.grupo1.lucaticket.dto.ResponseEventDto;
import com.grupo1.lucaticket.model.Ticket;
import com.grupo1.lucaticket.model.UserEntity;
import com.grupo1.lucaticket.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private UserEntityService userService;

    private static final Logger log = LoggerFactory.getLogger(TicketServiceImpl.class);

    public ResponseEventDto saveTicket(RequestEventDto eventDto) {
       log.info("---[SERVICE] GUARDANDO TICKET..." + repository.save(convertirTicket(eventDto)));
       return ResponseEventDto.builder()
                .nombreEvento(eventDto.getNombreEvento())
                .precioEvento(eventDto.getPrecioEvento())
                .message(eventDto.getMessage()).build();
    }

    public Ticket convertirTicket(RequestEventDto eventDto) {
        log.info("- - - TicketServiceImpl - Dentro de convertirTicket" + eventDto);
        return Ticket.builder()
                .nombreEvento(eventDto.getNombreEvento())
                .user(userService.findById(eventDto.getId_user()).orElseThrow())
                .precioEvento(eventDto.getPrecioEvento()).build();

    }
}
