package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.model.User;

public interface UserService {

	public void saveUser(User user); 
	
	public boolean doesMailExists(User user);

}
