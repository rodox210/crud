package com.rodd331.crud.impl.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@AllArgsConstructor
@lombok.Data
@Builder
public class ExceptionModel {

    private String name;
    private String message;
    private LocalDateTime timestamp;


}