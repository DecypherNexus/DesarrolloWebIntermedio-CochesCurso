package com.project.coches.exception;

public class PurchaseNotExistsException extends RuntimeException {

    public PurchaseNotExistsException() {
        super("La Factura no Existe.");
    }
}