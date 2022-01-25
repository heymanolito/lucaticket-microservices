package com.grupo1.lucaticket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo1.lucaticket.adapter.EventAdapter;
import com.grupo1.lucaticket.dto.EventResponse;
import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.service.EventService;

@Controller
@RequestMapping("/events")
public class EventController {

	private static final Logger log= LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService eventService;
	
	@Autowired 
	private EventAdapter eventAdapter;
	
	@GetMapping()
	public List<EventResponse> listEvents(){
		
		final List<Event> all= eventService.findAll();
		return eventAdapter.of(all);
	}
}
