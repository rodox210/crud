package com.rodd331.crud.impl.service;

import com.rodd331.crud.impl.handler.NotFoundException;
import com.rodd331.crud.impl.mapper.UserMapper;
import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.repository.UserEntity;
import com.rodd331.crud.impl.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersistenceService {

    private UserRepository userRepository;
// Todo reformular nomes dos metodos e centralizar o acesso ao banco

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserModel> listAllUsersReturn() {
        return userRepository.findAll().stream()
                .map(UserMapper::mapToModel)
                .collect(Collectors.toList());
    }

    public UserEntity userFindById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public UserEntity userUpdate(UserEntity user) {
        return userRepository.save(user);
    }

}
