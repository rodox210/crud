package com.rodd331.crud.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@lombok.Data
@Builder
public class ExceptionModel {

    private String name;
    private String message;
    private LocalDateTime timestamp;


}