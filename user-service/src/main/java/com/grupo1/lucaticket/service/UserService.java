package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.model.User;

public interface UserService {

	public User saveUser(User user); 
	
	public boolean doesMailExists(User user);

}
