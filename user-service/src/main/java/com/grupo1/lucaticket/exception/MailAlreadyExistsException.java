package com.grupo1.lucaticket.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class MailAlreadyExistsException extends DataIntegrityViolationException {


    public MailAlreadyExistsException() {
        super("El mail ya pertenece a otro usuario.");
    }

    public MailAlreadyExistsException(String mail) {
        super("El mail " + mail + " ya pertenece a otro usuario.");
    }
}
