package com.rodd331.crud.impl.facade;

import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import static com.rodd331.crud.stubs.UserEntityStub.generationUserEntity;
import static com.rodd331.crud.stubs.UserModelStub.generationUserModel;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {
        UserFacade.class,
        UserService.class})
public class UserFacadeTest {


    @Mock
    UserService userService;

    @InjectMocks
    UserFacade userFacade;

    @Test
    public void createUser() {
        UserModel teste = generationUserModel();
        when(userService.create(generationUserEntity())).thenReturn(generationUserEntity());
        userFacade.create(teste);
        verify(userService).create(generationUserEntity());
    }

   /* @Test
    public void allUsers() {
        List<UserModel> teste = new ArrayList<UserModel>();
        teste.add(generationUserModel());
        when(userService.listAll()).thenReturn(teste);
        userFacade.allUsers();
        verify(userService).listAll();
    }*/

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
    }

    @Test
    public void deleteById() {

        userFacade.delete("someid");
        verify(userService).delete("someid");
    }
}