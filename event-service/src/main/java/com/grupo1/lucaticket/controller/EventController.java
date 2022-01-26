package com.grupo1.lucaticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/events")
public class EventController {

	private static final Logger log = LoggerFactory.getLogger(EventController.class);

	@Autowired
	private EventService eventService;

	@Operation(summary = "Listado de eventos", description = "Muestra todos los eventos disponibles", tags = {
			"Eventos" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Mostrados eventos", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "404", description = "Error: No hay eventos", content = @Content) })
	@GetMapping()
	public ResponseEntity<?> listEvents() {

		List<Event> eventos = eventService.findAll();
		log.info("Recien buscada la lista de eventos");
		return ResponseEntity.ok(eventos);

	}

	@Operation(summary = "Añade un evento", description = "Sirve para añadir un evento a la base de datos", tags = {
			"Eventos" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento añadido correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "404", description = "Error: No se ha podido añadir añadir el evento", content = @Content) })
	@PostMapping("/add")
	public Event saveEvent(@RequestBody Event event) {
		log.info("-----Guardo el Evento");
		return eventService.saveEvent(event);
	}
}
