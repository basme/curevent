package com.curevent.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NotFoundException extends ResponceException {

    private final String message;
    private final HttpStatus httpStatus;


    public NotFoundException(String message) {
        this.message = message;
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}