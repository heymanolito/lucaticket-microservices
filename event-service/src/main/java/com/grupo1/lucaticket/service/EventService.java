package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.model.Event;

import java.util.List;

public interface EventService {


    Event saveEvent(Event event);

    List<Event> findAll();

}
