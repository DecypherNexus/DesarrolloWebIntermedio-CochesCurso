package com.project.coches.exception;

public class EmailValidationException extends RuntimeException {

    public EmailValidationException() {
        super("El Email no tiene el Formato Requerido.");
    }

}