package com.grupo1.lucaticket.controller;

import com.grupo1.lucaticket.dto.GetUserDto;
import com.grupo1.lucaticket.dto.adapter.UserDtoConverter;
import com.grupo1.lucaticket.model.UserEntity;
import com.grupo1.lucaticket.model.UserRole;
import com.grupo1.lucaticket.security.jwt.JwtTokenProvider;
import com.grupo1.lucaticket.security.jwt.model.JwtUserResponse;
import com.grupo1.lucaticket.security.jwt.model.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserDtoConverter converter;


    @PostMapping("/auth/login")
    public JwtUserResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("POST - Login");
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getEmail(),
                                loginRequest.getPassword()

                        )
                );
        log.info("Usuario autenticado");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserEntity user = (UserEntity) authentication.getPrincipal();
        String jwtToken = tokenProvider.generateToken(authentication);
        return convertUserEntityAndTokenToJwtUserResponse(user, jwtToken);

    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user/me")
    public GetUserDto me(@AuthenticationPrincipal UserEntity user) {
        return converter.convertUserEntityToGetUserDto(user);
    }


    private JwtUserResponse convertUserEntityAndTokenToJwtUserResponse(UserEntity user, String jwtToken) {
        return JwtUserResponse
                .jwtUserResponseBuilder()
                .fullName(user.getFullName())
                .email(user.getEmail())
                .roles(user.getRoles().stream().map(UserRole::name).collect(Collectors.toSet()))
                .token(jwtToken)
                .build();

    }

}
