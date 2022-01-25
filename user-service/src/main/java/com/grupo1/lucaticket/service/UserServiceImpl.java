package com.grupo1.lucaticket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo1.lucaticket.controller.UserController;
import com.grupo1.lucaticket.model.User;
import com.grupo1.lucaticket.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private static final Logger log= LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository repository;

	@Override
	public void saveUser(User user) {
		log.info("Antes de crear el juego");
		repository.save(user);
		log.info("Despues de crear el juego");
	}
	
	
}
