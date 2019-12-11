package com.rodd331.crud.impl.facade;

import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.repository.UserRepository;
import com.rodd331.crud.impl.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static com.rodd331.crud.stubs.UserEntityStub.generationUserEntity;
import static com.rodd331.crud.stubs.UserModelStub.generationUserModel;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {
        UserFacade.class,
        UserValidationService.class,
        UserService.class})
public class UserFacadeTest {

    @Mock
    UserRepository userRepository;

    @Mock
    UserService userService;

    @InjectMocks
    UserFacade userFacade;

    @Mock
    UserValidationService userValidationService;

    @Test
    public void createUser() {
        UserModel teste = generationUserModel();
        when(userService.create(generationUserEntity())).thenReturn(generationUserEntity());
        userFacade.create(teste);
        verify(userService).create(generationUserEntity());
        verify(userValidationService).checkForResgistredExistenceInDataBaseName(generationUserModel());
        verify(userValidationService).checkForResgistredExistenceInDataBaseEmail(generationUserModel());
    }

    @Test
    public void allUsers() {
        List<UserModel> teste = new ArrayList<UserModel>();
        teste.add(generationUserModel());
        when(userService.listAll()).thenReturn(teste);
        userFacade.allUsers();
        verify(userService).listAll();
        verify(userValidationService).validationEmptyList();
    }

    @Test
    public void findById() {
        when(userService.findById("someid")).thenReturn(generationUserEntity());
        userFacade.findById("someid");
        verify(userService).findById("someid");
    }

    @Test
    public void userUpdate() {
        UserModel teste = generationUserModel();
        when(userService.update(any())).thenReturn(generationUserEntity());
        userFacade.update(teste, "bobesponja");
        verify(userService).update(any());
        verify(userValidationService).validatorId("bobesponja");
    }

    @Test
    public void deleteById() {

        userFacade.delete("someid");
        verify(userValidationService).validatorId("someid");
        verify(userService).delete("someid");
    }
}