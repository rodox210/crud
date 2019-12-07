package com.rodd331.crud.impl.handler;

import lombok.Getter;


@Getter
public class ConflictException extends RuntimeException {

    public ConflictException(String message) {

        super(message);
    }

}
