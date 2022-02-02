package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.controller.UserController;
import com.grupo1.lucaticket.dto.CreateUserDto;
import com.grupo1.lucaticket.dto.GetUserDto;
import com.grupo1.lucaticket.dto.adapter.UserDtoConverter;
import com.grupo1.lucaticket.exception.NewUserWithDifferentPasswordsException;
import com.grupo1.lucaticket.model.UserEntity;
import com.grupo1.lucaticket.model.UserRole;
import com.grupo1.lucaticket.repository.UserEntityRepository;
import com.grupo1.lucaticket.util.UsernameGeneratorUtil;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService {

	private static final Logger log= LoggerFactory.getLogger(UserController.class);
	
	private final UserDtoConverter adapter;
	
    private final PasswordEncoder passwordEncoder;

    private final UserEntityRepository repositorio;

    public Optional<UserEntity> findByEmail(String email) {
        return this.repositorio.findByEmail(email);
    }

    
    @Override
    public Optional<UserEntity> findById(Long id) {
    	log.info("***Antes de encontrar el usuario por id");
    	Optional<UserEntity> optional=repositorio.findById(id);
    	if(optional.isEmpty()) {
        	log.info("***** No se ha encontrado usuario con ese id");
        	throw new NoSuchElementException("No existe ningun usuario con id: "+id);

    	}
        return repositorio.findById(id);

    }
    @Override
    public void deleteUser(UserEntity user) {
    		Optional<UserEntity> opt= repositorio.findById(user.getId());
    		if(opt.isEmpty()) {
    			log.info("***** No se ha encontrado usuario con este id");
            	throw new NoSuchElementException("No existe ningun usuario con id: "+user.getId());
    		}
    		repositorio.delete(user);
    }

    public UserEntity nuevoUsuario(CreateUserDto newUser) {

    	
        if ( newUser.getPassword().contentEquals(newUser.getPassword2()) ) {
            UserEntity userEntity = UserEntity.builder()
                    .username(UsernameGeneratorUtil.generateUsername(newUser.getEmail()))
                    .password(passwordEncoder.encode(newUser.getPassword()))
                    .password2(passwordEncoder.encode(newUser.getPassword()))
                    .fullName(newUser.getFullName())
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
	public void deleteAll() {
		repositorio.deleteAll();
	}


	@Override
	public UserEntity saveUser(UserEntity user) {
		return repositorio.save(user);
		
	}
	
	


	@Override
	public List<GetUserDto> findAll() {
		return adapter.of(repositorio.findAll());
	}


	@Override
	public void updateUser(UserEntity user) {
		repositorio.save(user);
	}



}
