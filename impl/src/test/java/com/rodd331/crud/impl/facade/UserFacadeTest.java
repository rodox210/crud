package com.rodd331.crud.impl.facade;

import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.repository.UserRepository;
import com.rodd331.crud.impl.service.PersistenceService;
import com.rodd331.crud.impl.service.ValidationService;
import org.junit.Assert;
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
        ValidationService.class,
        PersistenceService.class})
public class UserFacadeTest {

    @Mock
    UserRepository userRepository;

    @Mock
    PersistenceService persistenceService;

    @InjectMocks
    UserFacade userFacade;

    @Mock
    ValidationService validationService;

    @Test
    public void createUser() {
        UserModel teste = generationUserModel();
        when(persistenceService.createUser(any())).thenReturn(generationUserEntity());
        userFacade.createUser(teste);
        Assert.assertEquals(generationUserModel(), userFacade.createUser(generationUserModel()));

    }

    @Test
    public void allUsers() {
        List<UserModel> teste = new ArrayList<UserModel>();
        teste.add(generationUserModel());
        when(persistenceService.listAllUsersReturn()).thenReturn(teste);
        userFacade.allUsers();
        Assert.assertEquals(teste, userFacade.allUsers());
    }

    @Test
    public void findById() {
        when(persistenceService.userFindById(any())).thenReturn(generationUserEntity());
        userFacade.findById("someid");
        Assert.assertEquals(generationUserModel(), userFacade.findById("someid"));
    }

    @Test
    public void userUpdate() {
        UserModel teste = generationUserModel();
        when(persistenceService.userUpdate(any())).thenReturn(generationUserEntity());
        userFacade.userUpdate(teste, "bobesponja");
        Assert.assertEquals("bobesponja", teste.getId());

    }

    @Test
    public void deleteById() {

        userFacade.deleteById("someid");
        verify(validationService).validatorUserId("someid");
        verify(persistenceService).deleteUserById("someid");
    }
}