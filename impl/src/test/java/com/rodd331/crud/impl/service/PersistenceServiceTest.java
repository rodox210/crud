package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.repository.UserEntity;
import com.rodd331.crud.impl.repository.UserRepository;
import com.rodd331.crud.stubs.UserEntityStub;
import org.junit.Assert;
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
import static com.rodd331.crud.stubs.UserModelStub.generationUserModel;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersistenceServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    PersistenceService persistenceService;

    @Test
    public void createUser() {
        when(userRepository.save(any())).thenReturn(UserEntityStub.generationUserEntity());
        persistenceService.createUser(generationUserEntity());
        assertEquals(generationUserEntity(),
                persistenceService.createUser(generationUserEntity()));
    }

    @Test
    public void listAllUsersReturn() {
        List<UserEntity> teste = new ArrayList<>();
        teste.add(generationUserEntity());
        List<UserModel> teste1 = new ArrayList<>();
        teste1.add(generationUserModel());

        when(userRepository.findAll()).thenReturn(teste);
        persistenceService.listAllUsersReturn();
        assertEquals(teste1, persistenceService.listAllUsersReturn());

    }

    @Test
    public void userFindById() {
        when(userRepository.findById(any())).thenReturn(Optional.of(UserEntityStub.generationUserEntity()));
        persistenceService.userFindById("someid");
        assertEquals(generationUserEntity(),
                persistenceService.userFindById("someid"));
    }

    @Test
    public void deleteUserById() {
    persistenceService.deleteUserById("someid");
    verify(userRepository).deleteById("someid");
    }

    @Test
    public void userUpdate() {
        UserEntity teste = generationUserEntity2();
        when(userRepository.save(any())).thenReturn(UserEntityStub.generationUserEntity());
        persistenceService.userUpdate(teste);
        assertEquals(generationUserEntity(),
                persistenceService.userUpdate(teste));
    }
}