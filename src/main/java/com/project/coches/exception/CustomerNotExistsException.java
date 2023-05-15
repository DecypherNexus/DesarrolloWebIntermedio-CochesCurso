package com.project.coches.exception;

public class CustomerNotExistsException extends RuntimeException {

    public CustomerNotExistsException() {
        super("El Usuario ingresado no Existe.");
    }

}