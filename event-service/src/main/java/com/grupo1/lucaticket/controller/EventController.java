package com.grupo1.lucaticket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.service.EventService;

@Controller
@RequestMapping("/events")
public class EventController {

	private static final Logger log= LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService eventService;
	
	@GetMapping()
	public ResponseEntity<?> listEvents(){
		
		List<Event> eventos= eventService.findAll();
		log.info("Recien buscada la lista de eventos");
		return ResponseEntity.ok(eventos);
	}
}
