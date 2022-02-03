package com.grupo1.lucaticket.adapter;

import com.grupo1.lucaticket.dto.EventResponse;
import com.grupo1.lucaticket.model.Event;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventAdapter {

    public EventResponse of(Event event) {
        EventResponse eventResponse = new EventResponse();
        eventResponse.setId(event.getId());
        eventResponse.setCiudadRecinto(event.getRecinto().getCiudad());
        eventResponse.setFechaEvento(event.getFechaEvento());
        eventResponse.setHoraEvento(event.getHoraEvento());
        eventResponse.setNombre(event.getNombre());
        eventResponse.setNombreRecinto(event.getRecinto().getNombre());
        eventResponse.setGenero(event.getGenero());
        return eventResponse;

    }

    public List<EventResponse> of(List<Event> events) {
        return events.stream().map(this::of).collect(Collectors.toList());
    }
}
