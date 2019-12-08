package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.handler.ConflictException;
import com.rodd331.crud.impl.handler.NotFoundException;
import com.rodd331.crud.impl.repository.UserRepository;
import com.rodd331.crud.stubs.UserEntityStub;
import com.rodd331.crud.stubs.UserModelStub;
import org.junit.Assert;
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
public class ValidationServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    UserRepository userRepository;

    @InjectMocks
    ValidationService validationService;


    @Test
    public void checkForResgistredExistenceInDataBaseName() {
        expectedException.expectMessage("Name already registered");
        when(userRepository.findByUserName(any())).thenReturn(Optional.of(generationUserEntity()));
        validationService.checkForResgistredExistenceInDataBaseName(generationUserModel());
    }

    @Test
    public void checkForResgistredExistenceInDataBaseName_2() {
        when(userRepository.findByUserName(any())).thenReturn(Optional.empty());
        validationService.checkForResgistredExistenceInDataBaseName(generationUserModel());
        verify(userRepository).findByUserName(any());
    }

    @Test
    public void checkForResgistredExistenceInDataBaseEmail() {
        expectedException.expectMessage("Email already registered");
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(generationUserEntity()));
        validationService.checkForResgistredExistenceInDataBaseEmail(generationUserModel());
    }

    @Test
    public void checkForResgistredExistenceInDataBaseEmail_2() {
        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
        validationService.checkForResgistredExistenceInDataBaseEmail(generationUserModel());
        verify(userRepository).findByEmail(any());
    }

    @Test
    public void validationEmptyList() {
        expectedException.expectMessage("There are no registered users");
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        validationService.validationEmptyList();
    }

    @Test
    public void validationEmptyList_2() {
        List teste = new ArrayList();
        teste.add(generationUserEntity());
        when(userRepository.findAll()).thenReturn(teste);
        validationService.validationEmptyList();
        verify(userRepository).findAll();
    }

    @Test
    public void validatorUserId() {
        expectedException.expectMessage("User not found");
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        validationService.validatorUserId("someid");
    }

    @Test
    public void validatorUserId_2() {
        when(userRepository.findById(any())).thenReturn(Optional.of(generationUserEntity()));
        validationService.validatorUserId("someid");
        verify(userRepository).findById("someid");
    }
}