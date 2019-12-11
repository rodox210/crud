package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.handler.ApiException;
import com.rodd331.crud.impl.mapper.UserMapper;
import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.repository.UserEntity;
import com.rodd331.crud.impl.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserEntity create(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserModel> listAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::mapToModel)
                .collect(Collectors.toList());
    }

    public UserEntity findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public UserEntity update(UserEntity user) {
        return userRepository.save(user);
    }

    public void checkForResgistredExistenceInDataBaseName(UserModel user) {
        if (userRepository.findByUserName(user.getUserName()).isPresent()) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Name already registered");
        }
    }

    public void checkForResgistredExistenceInDataBaseEmail(UserModel user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Email already registered");
        }
    }

    public void validationEmptyList() {
        if (userRepository.findAll().isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, "There are no registered users");
        }
    }

    public void validatorId(String id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
}
