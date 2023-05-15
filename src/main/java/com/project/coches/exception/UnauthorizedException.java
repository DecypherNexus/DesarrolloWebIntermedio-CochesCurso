package com.project.coches.exception;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super("No Tiene los Permisos Necesarios.");
    }

}