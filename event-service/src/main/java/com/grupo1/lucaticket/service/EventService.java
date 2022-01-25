package com.grupo1.lucaticket.service;

import java.util.List;

import com.grupo1.lucaticket.model.Event;

public interface EventService {


	public void saveEvent(Event event);

	List<Event> findAll();

}
