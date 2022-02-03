package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.dto.EventResponse;
import com.grupo1.lucaticket.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    Event saveEvent(Event event);

    List<EventResponse> findAll();

    Optional<Event> findById(int id);

    void deleteAll();

    List<EventResponse> findByNombre(String nombre);

    List<EventResponse> findByGenero(String genero);

    List<EventResponse> findByCiudad(String ciudad);

    void delete(Event event);

    void updateEvent(Event event);
}
