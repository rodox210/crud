package com.rodd331.crud.impl.handler;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GenericHandlerTest {


    @InjectMocks
    GenericHandler genericHandler;



    @Test
    public void handlBadRequestException() {
        ExceptionResponse teste = genericHandler.handlBadRequestException();
        Assert.assertEquals("Campo invalido", teste.getMessage());

    }

    @Test
    public void handlerNotFoundException() {
        NotFoundException exception = new NotFoundException("Chapolin");
        ExceptionResponse teste = genericHandler.handlerNotFoundException(exception);
        Assert.assertEquals("NOT_FOUND", teste.getName());
    }

    @Test
    public void handlerConflictException() {
        ConflictException exception = new ConflictException("Chapolin");
        ExceptionResponse teste = genericHandler.handlerConflictException(exception);
        Assert.assertEquals("CONFLICT", teste.getName());
    }

}