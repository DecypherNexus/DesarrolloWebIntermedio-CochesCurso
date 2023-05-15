package com.project.coches.exception;

public class IncorrectPasswordException extends RuntimeException {

    public IncorrectPasswordException() {
        super("La Contraseña es Inválida.");
    }

}