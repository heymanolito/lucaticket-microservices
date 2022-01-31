package com.grupo1.lucaticket.exception;

public class NewUserWithDifferentPasswordsException extends RuntimeException {

    public NewUserWithDifferentPasswordsException() {
        super("Las contraseñas no coinciden.");
    }
}
