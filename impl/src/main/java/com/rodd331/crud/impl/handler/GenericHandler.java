package com.rodd331.crud.impl.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GenericHandler {

//Todo melhorar o retorno especificando os problemas que ocorreram de validação
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handlBadRequestException() {
        return new ExceptionResponse("BAD_REQUEST",
                "Campo invalido",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST);
    }


    //Todo tratamento de exception generica(incluindo null pointer)


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlerNotFoundException(NotFoundException exception) {
        return new ExceptionResponse("NOT_FOUND",
                exception.getMessage(),
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND);
    }

    //Todo ler documentação de todos os status
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse handlerConflictException(ConflictException exception) {
        return new ExceptionResponse("CONFLICT",
                exception.getMessage(),
                LocalDateTime.now(),
                HttpStatus.CONFLICT);
    }



}