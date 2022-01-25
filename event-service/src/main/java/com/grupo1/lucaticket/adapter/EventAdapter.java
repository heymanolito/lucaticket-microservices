package com.grupo1.lucaticket.adapter;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.grupo1.lucaticket.dto.EventResponse;
import com.grupo1.lucaticket.model.Event;

@Component
public class EventAdapter {

	public EventResponse of(Event event) {
		EventResponse eventResponse= new EventResponse();
		eventResponse.setCiudadRecinto(event.getRecinto().getCiudad());
		eventResponse.setFechaEvento(event.getFechaEvento());
		eventResponse.setHoraEvento(event.getHoraEvento());
		eventResponse.setNombre(event.getNombre());
		eventResponse.setNombreRecinto(event.getRecinto().getNombre());
		return eventResponse;
	}
	
	public List<EventResponse> of(List<Event> events){
		return events.stream().map(p -> of(p)).collect(Collectors.toList());
	}
}
