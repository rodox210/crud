package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.handler.ApiException;
import com.rodd331.crud.impl.handler.ExceptionModel;
import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ValidationService {

    private UserRepository userRepository;


    public void checkForResgistredExistenceInDataBaseEmailAndUserName(UserModel user) {
        if (userRepository.findByUserName(user.getUserName()).isPresent() &&
                userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, ExceptionModel
                    .builder()
                    .name("FieldAlreadyRegisteredException")
                    .message("User already registered")
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }

    public void validationEmptyList() {
        if (userRepository.findAll().isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, ExceptionModel
                    .builder()
                    .name("EmptyListException")
                    .message("There are no registered users")
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }

    public void validatorUserId(String id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, ExceptionModel
                    .builder()
                    .name("IdNotFoundException")
                    .message("User not found")
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }
}