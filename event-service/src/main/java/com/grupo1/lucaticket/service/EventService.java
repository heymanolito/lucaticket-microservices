package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {


    Event saveEvent(Event event);

    List<Event> findAll();

    Optional<Event> findById(int id);

}
