package com.rodd331.crud.handler;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericHandler {

    @NonNull
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionModel> handleApiException(ApiException exception) {
        return new ResponseEntity<>(exception.getException(), exception.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}