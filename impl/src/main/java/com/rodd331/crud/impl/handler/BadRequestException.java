package com.rodd331.crud.impl.handler;

import lombok.Getter;


@Getter
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {

        super(message);
    }

}
