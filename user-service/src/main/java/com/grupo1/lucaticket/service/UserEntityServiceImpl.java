package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.dto.CreateUserDto;
import com.grupo1.lucaticket.exception.NewUserWithDifferentPasswordsException;
import com.grupo1.lucaticket.model.UserEntity;
import com.grupo1.lucaticket.model.UserRole;
import com.grupo1.lucaticket.repository.UserEntityRepository;
import com.grupo1.lucaticket.util.UsernameGeneratorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService {

    private final PasswordEncoder passwordEncoder;

    private final UserEntityRepository repositorio;

    public Optional<UserEntity> findByEmail(String email) {
        return this.repositorio.findByEmail(email);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return Optional.empty();
    }

    public UserEntity nuevoUsuario(CreateUserDto newUser) {

        if ( newUser.getPassword().contentEquals(newUser.getPassword2()) ) {
            UserEntity userEntity = UserEntity.builder()
                    .username(UsernameGeneratorUtil.generateUsername(newUser.getEmail()))
                    .password(passwordEncoder.encode(newUser.getPassword()))
                    .fullName(newUser.getFullname())
                    .email(newUser.getEmail())
                    .roles(Stream.of(UserRole.USER).collect(Collectors.toSet())).build();
            try {
                return repositorio.save(userEntity);
            } catch (DataIntegrityViolationException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo ya está registrado");
            }
        } else {
            throw new NewUserWithDifferentPasswordsException();
        }

    }

    @Override
    public boolean doesMailExists(UserEntity user) {
        return false;
    }

}
