package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.repository.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.rodd331.crud.stubs.UserEntityStub.generationUserEntity;
import static com.rodd331.crud.stubs.UserModelStub.generationUserModel;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserValidationServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserValidationService userValidationService;


    @Test
    public void checkForResgistredExistenceInDataBaseName() {
        expectedException.expectMessage("Name already registered");
        when(userRepository.findByUserName(any())).thenReturn(Optional.of(generationUserEntity()));
        userValidationService.checkForResgistredExistenceInDataBaseName(generationUserModel());
    }

    @Test
    public void checkForResgistredExistenceInDataBaseName_2() {
        when(userRepository.findByUserName(any())).thenReturn(Optional.empty());
        userValidationService.checkForResgistredExistenceInDataBaseName(generationUserModel());
        verify(userRepository).findByUserName(any());
    }

    @Test
    public void checkForResgistredExistenceInDataBaseEmail() {
        expectedException.expectMessage("Email already registered");
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(generationUserEntity()));
        userValidationService.checkForResgistredExistenceInDataBaseEmail(generationUserModel());
    }

    @Test
    public void checkForResgistredExistenceInDataBaseEmail_2() {
        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
        userValidationService.checkForResgistredExistenceInDataBaseEmail(generationUserModel());
        verify(userRepository).findByEmail(any());
    }

    @Test
    public void validationEmptyList() {
        expectedException.expectMessage("There are no registered users");
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        userValidationService.validationEmptyList();
    }

    @Test
    public void validationEmptyList_2() {
        List teste = new ArrayList();
        teste.add(generationUserEntity());
        when(userRepository.findAll()).thenReturn(teste);
        userValidationService.validationEmptyList();
        verify(userRepository).findAll();
    }

    @Test
    public void validatorUserId() {
        expectedException.expectMessage("User not found");
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        userValidationService.validatorId("someid");
    }

    @Test
    public void validatorUserId_2() {
        when(userRepository.findById(any())).thenReturn(Optional.of(generationUserEntity()));
        userValidationService.validatorId("someid");
        verify(userRepository).findById("someid");
    }
}