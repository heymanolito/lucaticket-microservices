package com.grupo1.lucaticket.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		List<EventResponse> result = eventService.findAll();
		return ResponseEntity.ok(result);
	}

	@Operation(summary = "Añade un evento", description = "Sirve para añadir un evento a la base de datos", tags = {
			"Eventos" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento añadido correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "404", description = "Error: No se ha podido añadir añadir el evento", content = @Content) })

	@PostMapping("/add")
	public ResponseEntity<Event> create(@RequestBody @Valid Event event) {
		log.info("------ create (POST)");
		Event saved = eventService.saveEvent(event);
		log.info("------ Evento guardado (POST)");

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@Operation(summary = "Busca un evento", description = "Sirve para buscar un evento en la base de datos dado su id", tags = {
			"id" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento encontrado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "404", description = "Error: No se ha encotrado el evento", content = @Content) })

	@GetMapping("/{id}")
	public ResponseEntity<?> showEventDetails(@PathVariable int id) {
		log.info("**** Recien entrado");
		Event found = eventService.findById(id).orElseThrow();
		log.info("Antes de encontrar el evento");
		return ResponseEntity.ok(found);
	}

	@Operation(summary = "Busca una lista de eventos", description = "Sirve para filtrar la lista de eventos en la base de datos dado su genero", tags = {
			"genero" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Eventos encontrados correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "404", description = "Error: No se ha encotrado ningun evento con este genero", content = @Content) })

	@GetMapping("/genero/{genero}")
	public ResponseEntity<?> findByGenero(@PathVariable String genero) {
		log.info("Antes de encontrar los eventos por genero");
		List<EventResponse> result = eventService.findByGenero(genero);
		log.info("Después de encontrar los eventos");
		return ResponseEntity.ok(result);

	}

	@Operation(summary = "Elimina un evento", description = "Sirve para eliminar un evento de la base de datos dado su id", tags = {
			"id" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Evento eliminado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "404", description = "Error: No se ha encotrado ningun evento con este id", content = @Content) })

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEvento(@PathVariable int id) {
		log.info("Antes de borrar el evento");
		Event deleted = eventService.findById(id).orElseThrow();
		eventService.delete(deleted);
		log.info("Después de borrar el evento");
		return ResponseEntity.noContent().build();
		
	}

	@Operation(summary = "Busca un evento que incluya cierta palabra", description = "Sirve para buscar una lista de eventos en la base de datos dado un nombre", tags = {
			"nombre" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Eventos encontrados correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "404", description = "Error: No se ha encotrado ningún evento", content = @Content) })

	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<?> findByNombre(@PathVariable String nombre) {
		log.info("Antes de encontrar los eventos");
		List<EventResponse> result = eventService.findByNombre(nombre);
		log.info("Después de encontrar los eventos");
		return ResponseEntity.ok(result);
	}

	@Operation(summary = "Modifica un evento", description = "Sirve para modificar un evento de la base de datos dado su id", tags = {
			"id" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Evento modificado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "404", description = "Error: No se ha encotrado ningun evento con este id", content = @Content) })
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEvent(@PathVariable int id) {
		log.info("Antes de modificar el evento");
		Event modified = eventService.findById(id).orElseThrow();
		eventService.updateEvent(modified);
		log.info("Después de modificar el evento");
		return ResponseEntity.ok(modified);
	}

}
