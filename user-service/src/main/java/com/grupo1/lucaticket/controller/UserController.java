package com.grupo1.lucaticket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo1.lucaticket.model.User;
import com.grupo1.lucaticket.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/users")
public class UserController {

	public static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@Operation(summary = "Añade un evento", description = "Sirve para añadir un evento a la base de datos", tags = {
			"Eventos" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento añadido correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),

			@ApiResponse(responseCode = "404", description = "Error: No se ha podido añadir añadir el evento", content = @Content) })
	@PostMapping("/add")
	public void saveEvent(@RequestBody User user) {
		userService.saveUser(user);
		log.info("***Usuario guardado");
	}
}
