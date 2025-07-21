package org.rdutta.ezflight.infrastructure.exceptions;

public class BrandNotFound extends RuntimeException{
    public BrandNotFound(String message) {
        super(message);
    }
}
