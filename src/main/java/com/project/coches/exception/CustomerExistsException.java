package com.project.coches.exception;

public class CustomerExistsException extends RuntimeException {

    public CustomerExistsException() {
        super("El Usuario ingresado ya se encuentra Registrado.");
    }

}