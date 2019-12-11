package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.repository.UserEntity;
import com.rodd331.crud.impl.repository.UserRepository;
import com.rodd331.crud.stubs.UserEntityStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.rodd331.crud.stubs.UserEntityStub.generationUserEntity;
import static com.rodd331.crud.stubs.UserEntityStub.generationUserEntity2;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void createUser() {
        when(userRepository.save(any())).thenReturn(UserEntityStub.generationUserEntity());
        userService.create(generationUserEntity());
        verify(userRepository).save(generationUserEntity());
    }

    @Test
    public void listAllUsersReturn() {
        List<UserEntity> teste = new ArrayList<>();
        teste.add(generationUserEntity());

        when(userRepository.findAll()).thenReturn(teste);
        userService.listAll();
        verify(userRepository).findAll();
    }

    @Test
    public void userFindById() {
        when(userRepository.findById(any())).thenReturn(Optional.of(UserEntityStub.generationUserEntity()));
        userService.findById("someid");
        verify(userRepository).findById("someid");
    }

    @Test
    public void deleteUserById() {
        userService.delete("someid");
        verify(userRepository).deleteById("someid");
    }

    @Test
    public void userUpdate() {
        UserEntity teste = generationUserEntity2();
        when(userRepository.save(any())).thenReturn(UserEntityStub.generationUserEntity());
        userService.update(teste);
        verify(userRepository).save(teste);
    }
}