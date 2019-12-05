package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.handler.BadRequestException;
import com.rodd331.crud.impl.handler.ExceptionResponse;
import com.rodd331.crud.impl.handler.NotFoundException;
import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ValidationService {

    private UserRepository userRepository;


    public void checkForResgistredExistenceInDataBaseName(UserModel user) {
        if (userRepository.findByUserName(user.getUserName()).isPresent()) {
            throw new BadRequestException("Name already registered");
        }
    }


    public void checkForResgistredExistenceInDataBaseEmail(UserModel user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("User already registered");
        }
    }

    public void validationEmptyList() {
        if (userRepository.findAll().isEmpty()) {
            throw new NotFoundException("There are no registered users");
        }
    }

    public void validatorUserId(String id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new BadRequestException("User not found");
        }
    }
}