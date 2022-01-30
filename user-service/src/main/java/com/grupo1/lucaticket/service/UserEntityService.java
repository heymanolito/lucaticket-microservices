package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.dto.CreateUserDto;
import com.grupo1.lucaticket.model.UserEntity;

import java.util.Optional;

public interface UserEntityService {

    UserEntity nuevoUsuario(CreateUserDto user);

    boolean doesMailExists(UserEntity user);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findById(Long id);
}
