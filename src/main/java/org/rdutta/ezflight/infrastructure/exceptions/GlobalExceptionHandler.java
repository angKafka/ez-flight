package org.rdutta.ezflight.infrastructure.exceptions;

import org.rdutta.ezflight.infrastructure.exceptions.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BrandNotFound.class)
    public ExceptionDto whenNotFoundBrandById(BrandNotFound brandNotFound){
        return new ExceptionDto(
                HttpStatus.NOT_FOUND.value(),
                brandNotFound.getLocalizedMessage()
        );
    }

    @ExceptionHandler(FlightsNotFound.class)
    public ExceptionDto whenNoFlightsFoundWithId(FlightsNotFound flightsNotFound){
        return new ExceptionDto(
                HttpStatus.NOT_FOUND.value(),
                flightsNotFound.getLocalizedMessage()
        );
    }
}
