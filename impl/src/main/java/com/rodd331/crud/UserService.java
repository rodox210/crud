package com.rodd331.crud;

import com.rodd331.crud.crypto.Cryptograf;
import com.rodd331.crud.handler.ApiException;
import com.rodd331.crud.handler.ExceptionModel;
import com.rodd331.crud.mapper.UserMapper;
import com.rodd331.crud.model.UserModel;
import com.rodd331.crud.repository.UserEntity;
import com.rodd331.crud.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.rodd331.crud.mapper.UserMapper.mapToEntity;
import static com.rodd331.crud.mapper.UserMapper.mapToModel;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    UserEntity createUser(UserModel user) {
        if(userRepository.findByUserName(user.getUserName()).isEmpty() &&
                userRepository.findByEmail(user.getEmail()).isEmpty()){
            String crypt = Cryptograf.criptografar(user.getUserPassword());
            user.setUserPassword(crypt);
            return userRepository.save(mapToEntity(user));
        }else{
            throw getApiExceptionalReadyRegistered();
    }}

    List<UserModel> allUsers() {
        if(userRepository.findAll().isEmpty()){
            throw getApiExceptionIdNotFound();
        }else{
        return userRepository.findAll().stream().map(UserMapper::mapToModel).collect(Collectors.toList());
    }}

    UserEntity findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(this::getApiExceptionIdNotFound);
    }

    UserEntity userUpdate(UserModel user, String id) {
        if (userRepository.findById(id).isPresent()) {
            user.setId(id);

            return userRepository.save(UserMapper.mapToEntity(user));
        } else {
            throw getApiExceptionIdNotFound();
        }
    }

      void deleteUserById(String id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw getApiExceptionIdNotFound();
        }
    }


    private ApiException getApiExceptionIdNotFound() {
        return new ApiException(HttpStatus.NOT_FOUND, ExceptionModel.builder()
                .message("TargetNotFoundException")
                .name("Id incorreto")
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build());
    }

    private ApiException getApiExceptionalReadyRegistered() {
        return new ApiException(HttpStatus.BAD_REQUEST, ExceptionModel.builder()
                .message("Data Already Registered")
                .name("Dado ja Cadastrado")
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now())
                .build());
    }


}