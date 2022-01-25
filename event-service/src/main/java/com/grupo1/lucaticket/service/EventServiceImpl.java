package com.grupo1.lucaticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService{

	//@Autowired
	//private EventRepository eventServ;

	@Override
	public void saveEvent(Event event) {
		
		//eventServ.save(event);
	}
}
