package com.grupo1.lucaticket.service;

import java.util.List;
import java.util.Optional;

import com.grupo1.lucaticket.dto.CreateUserDto;
import com.grupo1.lucaticket.dto.GetUserDto;
import com.grupo1.lucaticket.model.UserEntity;

public interface UserEntityService {

    UserEntity nuevoUsuario(CreateUserDto user);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findById(Long id);
    
    void deleteUser(UserEntity user);
    
    void deleteAll();
    
    UserEntity saveUser(UserEntity user);
    
    List<GetUserDto> findAll();
    
    void updateUser(UserEntity user);
    
    
}
