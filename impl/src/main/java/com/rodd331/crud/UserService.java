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

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    UserEntity createUser(UserModel user) {
        if (userRepository.findByUserName(user.getUserName()).isEmpty() &&
                userRepository.findByEmail(user.getEmail()).isEmpty()) {
            String crypt = Cryptograf.criptografar(user.getUserPassword());
            user.setUserPassword(crypt);
            return userRepository.save(mapToEntity(user));
        } else {
            throw new ApiException(HttpStatus.BAD_REQUEST, ExceptionModel
                    .builder()
                    .name("FieldAlreadyRegisteredException")
                    .message( "User already registered")
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }

    List<UserModel> allUsers() {
        if (userRepository.findAll().isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, ExceptionModel
                    .builder()
                    .name("EmptyListException")
                    .message( "There are no registered users")
                    .timestamp(LocalDateTime.now())
                    .build());
        } else {
            return userRepository.findAll().stream().map(UserMapper::mapToModel).collect(Collectors.toList());
        }
    }

    UserEntity findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, ExceptionModel
                .builder()
                .name("IdNotFoundException")
                .message( "User not found")
                .timestamp(LocalDateTime.now())
                .build()));
    }

    UserEntity userUpdate(UserModel user, String id) {
        if (userRepository.findById(id).isPresent()) {
            user.setId(id);

            return userRepository.save(UserMapper.mapToEntity(user));
        } else {
            throw new ApiException(HttpStatus.NOT_FOUND, ExceptionModel
                    .builder()
                    .name("IdNotFoundException")
                    .message( "User not found")
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }

    void deleteUserById(String id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new ApiException(HttpStatus.NOT_FOUND, ExceptionModel
                    .builder()
                    .name("IdNotFoundException")
                    .message( "User not found")
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }





}