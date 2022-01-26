package com.grupo1.lucaticket.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo1.lucaticket.exception.MailAlreadyExistsException;
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

	@Operation(summary = "Añade un evento", description = "Sirve para añadir un usuario a la base de datos", tags = {
			"User" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario añadido correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),

			@ApiResponse(responseCode = "404", description = "Error: No se ha podido añadir añadir el usuario", content = @Content) })
	@PostMapping("/add")
	public void saveUser(@RequestBody User user) {

		try {
			if (userService.doesMailExists(user) == false) {
				log.info("Si no existe el mail");
				userService.saveUser(user);
				log.info("***Usuario guardado");
			} else {
				log.info("Si existe el mail");
				throw new MailAlreadyExistsException();
			}
		} catch (MailAlreadyExistsException e) {
			e.printStackTrace();
		}

	}

}
