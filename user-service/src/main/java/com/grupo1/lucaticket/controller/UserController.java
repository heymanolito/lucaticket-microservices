package com.grupo1.lucaticket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo1.lucaticket.dto.CreateUserDto;
import com.grupo1.lucaticket.dto.GetUserDto;
import com.grupo1.lucaticket.dto.adapter.UserDtoConverter;
import com.grupo1.lucaticket.model.UserEntity;
import com.grupo1.lucaticket.service.UserEntityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	
    private final UserEntityService userEntityService;
    private final UserDtoConverter userDtoConverter;


    @Operation(summary = "Anade un user", description = "Sirve para aÃ±adir un user a la base de datos", tags = {
	"Usuario" })
@ApiResponses(value = {
	@ApiResponse(responseCode = "200", description = "User anadido correctamente", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class)) }),
	@ApiResponse(responseCode = "404", description = "Error: No se ha podido anadir el user", content = @Content) })

    @PostMapping("/register")
    public GetUserDto nuevoUsuario(@RequestBody CreateUserDto newUser) {
        return userDtoConverter.convertUserEntityToGetUserDto(userEntityService.nuevoUsuario(newUser));

    }
    
    
    @Operation(summary = "Elimina un user", description = "Sirve para eliminar un usuario de la base de datos dado su id", tags = {
	"id" })
@ApiResponses(value = {
	@ApiResponse(responseCode = "204", description = "Evento eliminado correctamente", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class)) }),
	@ApiResponse(responseCode = "404", description = "Error: No se ha encotrado ningun usuario con este id", content = @Content) })

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity <?> deleteUser(@PathVariable Long id){
    	log.info("Antes de borrar el usuario");
    	UserEntity deleted= userEntityService.findById(id).orElseThrow();
    	userEntityService.deleteUser(deleted);
    	log.info("Despues de borrar el evento");
    	return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Listado de usuarios", description = "Muestra todos los usuarios disponibles", tags = {
	"Usuarios" })
@ApiResponses(value = {
	@ApiResponse(responseCode = "200", description = "Mostrados Usuarios", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class)) }),
	@ApiResponse(responseCode = "404", description = "Error: No hay Usuarios", content = @Content) })

    @GetMapping()
    public ResponseEntity<?> listUsers(){
    	List<GetUserDto> result = userEntityService.findAll();
    	return ResponseEntity.ok(result);
    }
    
    
    @Operation(summary = "Busca un usuario", description = "Sirve para buscar un usuario en la base de datos dado su id", tags = {
	"id" })
@ApiResponses(value = {
	@ApiResponse(responseCode = "200", description = "Usuario encontrado correctamente", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class)) }),
	@ApiResponse(responseCode = "404", description = "Error: No se ha encotrado el usuario", content = @Content) })

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id){
    	log.info("****Antes de encontrar el user");
    	UserEntity found= userEntityService.findById(id).orElseThrow();
    	log.info("Usuario encontrado");
    	return ResponseEntity.ok(found);
    }
    
    
    @Operation(summary = "Modifica un usuario", description = "Sirve para modificar un usuario de la base de datos dado su id", tags = {
	"id" })
@ApiResponses(value = {
	@ApiResponse(responseCode = "204", description = "Usario modificado correctamente", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class)) }),
	@ApiResponse(responseCode = "404", description = "Error: No se ha encotrado ningun usuario con este id", content = @Content) })

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, BindingResult result){
    	log.info("Antes de modificar el evento");
    	UserEntity modified= userEntityService.findById(id).orElseThrow();
    	userEntityService.updateUser(modified);
    	log.info("MODIFICADO");
    	return ResponseEntity.ok(modified);
    }
    

}
