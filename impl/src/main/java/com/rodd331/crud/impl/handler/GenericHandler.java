package com.rodd331.crud.impl.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionModel> handleApiException(ApiException exception) {
        return new ResponseEntity<>(exception.getException(), exception.getStatus());
    }


}