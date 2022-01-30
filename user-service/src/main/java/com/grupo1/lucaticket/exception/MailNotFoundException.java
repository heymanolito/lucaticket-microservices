package com.grupo1.lucaticket.exception;

import org.springframework.security.core.AuthenticationException;

public class MailNotFoundException extends AuthenticationException {

    public MailNotFoundException(String msg) {
        super(msg);
    }
}
