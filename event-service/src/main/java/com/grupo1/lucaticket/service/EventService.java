package com.grupo1.lucaticket.service;

import java.util.List;
import java.util.Optional;

import com.grupo1.lucaticket.model.Event;

public interface EventService {


	public Event saveEvent(Event event);

	List<Event> findAll();

	public Optional<Event> findById(int id);
}
