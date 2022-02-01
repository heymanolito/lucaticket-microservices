package com.grupo1.lucaticket.repository;

import com.grupo1.lucaticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
