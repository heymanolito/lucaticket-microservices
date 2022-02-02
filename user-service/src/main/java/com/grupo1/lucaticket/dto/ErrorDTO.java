package com.grupo1.lucaticket.dto;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDTO {

	private int status;
	private String message;
	//private Date timestamp;
	List<String> errors;
	
	ErrorDTO(String message){
		this.message = message;
	}
	

}
