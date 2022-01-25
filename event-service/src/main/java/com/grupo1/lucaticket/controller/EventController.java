package com.grupo1.lucaticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.service.EventService;

@RestController
public class EventController {

	//@Autowired
	//private EventService eventService;

	@GetMapping("/add")
	public void saveEvent(@RequestBody Event event) {
		//eventService.saveEvent(event);
	}
}
