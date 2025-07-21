package org.rdutta.ezflight.infrastructure.exceptions.dto;

public record ExceptionDto(
        int statusCode,
        String exception
) {
}
