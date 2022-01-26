package com.grupo1.lucaticket.exception;

public class MailAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 1L;

	public MailAlreadyExistsException() {
		super("El mail ya pertenece a otro usuario.");
	}
	public MailAlreadyExistsException(String mail) {
		super("El mail " + mail + " ya pertenece a otro usuario.");
	}	
}
