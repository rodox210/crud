package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.handler.BadRequestException;
import com.rodd331.crud.impl.handler.NotFoundException;
import com.rodd331.crud.impl.repository.UserRepository;
import com.rodd331.crud.stubs.UserEntityStub;
import com.rodd331.crud.stubs.UserModelStub;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;

import java.util.Collections;
import java.util.Optional;

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
        expectedException.expect(BadRequestException.class);
        expectedException.expectMessage("Name already registered");
        when(userRepository.findByUserName(any())).thenReturn(Optional.of(UserEntityStub.generationUserEntity()));
        validationService.checkForResgistredExistenceInDataBaseName(UserModelStub.generationUserModel());
    }

    @Test
    public void checkForResgistredExistenceInDataBaseEmail() {
        expectedException.expect(BadRequestException.class);
        expectedException.expectMessage("Email already registered");
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(UserEntityStub.generationUserEntity()));
        validationService.checkForResgistredExistenceInDataBaseEmail(UserModelStub.generationUserModel());
    }

    @Test
    public void validationEmptyList() {
        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("There are no registered users");
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        validationService.validationEmptyList();
    }

    @Test
    public void validatorUserId() {
        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("User not found");
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        validationService.validatorUserId("someid");
    }
}