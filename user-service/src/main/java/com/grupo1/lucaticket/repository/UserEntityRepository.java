package com.grupo1.lucaticket.repository;

import java.util.Optional;

import com.grupo1.lucaticket.dto.CreateUserDto;
import com.grupo1.lucaticket.model.UserEntity;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
	
	Optional<UserEntity> findByEmail(String email);


}
