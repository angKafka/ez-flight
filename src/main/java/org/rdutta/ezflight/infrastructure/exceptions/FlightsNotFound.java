package org.rdutta.ezflight.infrastructure.exceptions;

public class FlightsNotFound extends RuntimeException {
    public FlightsNotFound(String message) {
        super(message);
    }
}
