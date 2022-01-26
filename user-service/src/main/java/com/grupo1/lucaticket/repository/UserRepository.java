package com.grupo1.lucaticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo1.lucaticket.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByMail(String mail);
	
}
