package com.grupo1.lucaticket.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/users")
public class UserController {

	/*
	 * Ejemplo para Documentacion API: Adaptar al método
	 * 
	 * 
	@Operation(summary = "Listado de eventos", description = "Muestra todos los eventos disponibles", tags = {
			"Eventos" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Mostrados eventos", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "404", description = "Error: No hay eventos", content = @Content) })
	@GetMapping()
	public ResponseEntity<?> listEvents() {

	}
	 * 
	 */

	
}
