package com.grupo1.lucaticket.controller;

import com.grupo1.lucaticket.dto.CreateUserDto;
import com.grupo1.lucaticket.dto.GetUserDto;
import com.grupo1.lucaticket.dto.adapter.UserDtoConverter;
import com.grupo1.lucaticket.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserEntityService userEntityService;
    private final UserDtoConverter userDtoConverter;


    @PostMapping("/register")
    public GetUserDto nuevoUsuario(@RequestBody CreateUserDto newUser) {
        return userDtoConverter.convertUserEntityToGetUserDto(userEntityService.nuevoUsuario(newUser));

    }

}
