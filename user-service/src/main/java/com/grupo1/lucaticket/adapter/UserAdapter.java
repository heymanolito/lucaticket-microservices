package com.grupo1.lucaticket.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.grupo1.lucaticket.dto.UserResponse;
import com.grupo1.lucaticket.model.User;

@Component
public class UserAdapter {

	public UserResponse of(User user) {
		UserResponse userResponse= new UserResponse();
		userResponse.setNombreCompleto(user.getNombre()+" "+user.getApellidos());
		userResponse.setMail(user.getMail());
		return userResponse;
	}
	
	public List<UserResponse> of(List<User> users){
		return users.stream().map(p->of(p)).collect(Collectors.toList());
	}
}
