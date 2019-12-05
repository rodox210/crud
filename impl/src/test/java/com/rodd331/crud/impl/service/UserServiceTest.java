/*package com.rodd331.crud.impl.service;


import com.rodd331.crud.impl.handler.ApiException;
import com.rodd331.crud.impl.repository.UserRepository;
import com.rodd331.crud.stubs.UserModelStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test(expected = ApiException.class)
    public void getAllUsers_ReturnApiException() {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        userService.allUsers();
    }

    @Test(expected = ApiException.class)
    public void getFindById_ReturnApiException() {
        userService.findById("someid");
    }

    @Test(expected = ApiException.class)
    public void createUser_ReturnApiException() {
        when(userRepository.findByUserName(any())).thenReturn(Optional.of(UserEntityStub.generationUserEntity()));
        userService.createUser(UserModelStub.generationUserModel());
    }

    @Test(expected = ApiException.class)
    public void deleteUserById_ReturnApiException() {
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        userService.deleteUserById("someid");
    }

    @Test(expected = ApiException.class)
    public void userUpdate_ReturnApiException() {
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        userService.userUpdate(UserModelStub.generationUserModel(),"someid");
    }
}*/

