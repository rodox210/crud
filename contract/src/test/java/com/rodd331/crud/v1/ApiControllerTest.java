package com.rodd331.crud.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rodd331.crud.impl.facade.UserFacade;
import com.rodd331.crud.impl.mapper.UserMapper;
import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.repository.UserEntity;
import com.rodd331.crud.impl.repository.UserRepository;
import com.rodd331.crud.impl.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static com.rodd331.crud.stubs.UserEntityStub.generationUserEntity2;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ApiController.class)
@ContextConfiguration(classes = {ApiController.class,
        UserContractFacade.class,
        UserFacade.class,
        UserService.class})
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void findById_ReturnCode_OK() throws Exception {
        given(userRepository.findById("someid")).willReturn(java.util.Optional.of(generationUserEntity2()));
        this.mockMvc.perform(get("/crud/v1/user/someid"))
                .andExpect(status().isOk());
    }
/*
    @Test
    public void allUsers_ReturnCode_OK() throws Exception {
        List<UserEntity> teste = new ArrayList<UserEntity>();
        teste.add(generationUserEntity());
        given(userRepository.findAll()).willReturn(teste);
        this.mockMvc.perform(get("/crud/v1/user")).andExpect(status().isOk());
    }*/


    @Test
    public void createUser_ReturnCode_Created() throws Exception {
        UserEntity userEntityExample = new UserEntity("someid", "teste", "test@hotmail.com", "123456");
        given(userRepository.findByUserName(any())).willReturn(Optional.empty());
        given(userRepository.findByEmail(any())).willReturn(Optional.empty());
        given(userRepository.save(any())).willReturn(userEntityExample);
        this.mockMvc.perform(post("/crud/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper()
                        .writeValueAsString(UserEntity.builder().id("someid").userName("teste")
                                .email("test@hotmail.com").userPassword("123456").build())))
                .andExpect(status().isCreated());
    }

    @Test
    public void deleteFindById_ReturnCode_Ok() throws Exception {
        UserEntity userEntityExample = new UserEntity("someid", "teste", "test@mail.com", "123456");
        given(userRepository.findById("someid")).willReturn(java.util.Optional.of(userEntityExample));
        this.mockMvc.perform(delete("/crud/v1/user/someid")).andExpect(status().isNoContent());
    }


    @Test
    public void updateUser_ReturnCode_OK() throws Exception {
        UserModel userModelExample = new UserModel("someid", "teste", "test@hotmail.com", "123456");
        UserEntity userEntityExample = new UserEntity("someid", "teste", "test@hotmail.com", "123456");
        given(userRepository.findById("someid")).willReturn(java.util.Optional.of(userEntityExample));
        given(userRepository.save(UserMapper.mapToEntity(userModelExample))).willReturn(userEntityExample);
        this.mockMvc.perform(put("/crud/v1/user/someid")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper()
                        .writeValueAsString(UserEntity.builder().userName("teste").email("test@hotmail.com").userPassword("123456").build()))).andExpect(status().isOk());
    }
}
