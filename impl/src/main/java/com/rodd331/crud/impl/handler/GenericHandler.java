package com.rodd331.crud.impl.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GenericHandler {

    @ExceptionHandler(NotFoundException.class)
    public ExceptionResponse handlerNotFoundException(NotFoundException exception) {
        return new ExceptionResponse("NOT_FOUND",
                exception.getMessage(),
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ExceptionResponse handlerBadRequestException(BadRequestException exception) {
        return new ExceptionResponse("BAD_REQUEST",
                exception.getMessage(),
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST);
    }

}