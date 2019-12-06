package com.rodd331.crud.impl.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GenericHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse handlBadRequestException() {
        return new ExceptionResponse("BAD_REQUEST",
                "Campo invalido",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionResponse handlerNotFoundException(NotFoundException exception) {
        return new ExceptionResponse("NOT_FOUND",
                exception.getMessage(),
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse handlerBadRequestException(BadRequestException exception) {
        return new ExceptionResponse("BAD_REQUEST",
                exception.getMessage(),
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST);
    }



}