package com.rodd331.crud.v1;

import com.rodd331.crud.impl.facade.UserFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserContractFacadeTest {

    @Mock
    UserFacade userFacade;

    @InjectMocks
    UserContractFacade userContractFacade;

/*
    @Test
    public void createUser() {

    }

    @Test
    public void allUsers() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void userUpdate() {
    }*/

    @Test
    public void deleteById() {
        userContractFacade.delete("someid");
        verify(userFacade).delete("someid");

    }
}