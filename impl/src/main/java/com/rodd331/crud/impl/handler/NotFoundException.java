package com.rodd331.crud.impl.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class NotFoundException extends RuntimeException {

    private String message;

}
