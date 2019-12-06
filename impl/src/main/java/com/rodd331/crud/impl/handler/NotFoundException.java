package com.rodd331.crud.impl.handler;

import lombok.Getter;


@Getter
public class NotFoundException extends RuntimeException {


    public NotFoundException(String message) {
        super(message);

    }
}
