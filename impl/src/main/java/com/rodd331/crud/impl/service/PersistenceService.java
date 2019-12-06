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

import static com.rodd331.crud.impl.mapper.UserMapper.mapToEntity;

@Service
@AllArgsConstructor
public class PersistenceService {

    private UserRepository userRepository;


    public UserEntity createUser(UserModel user) {
        return userRepository.save(mapToEntity(user));
    }

    public List<UserModel> listAllUsersReturn() {
        return userRepository.findAll().stream().map(UserMapper::mapToModel).collect(Collectors.toList());
    }

    public UserEntity userFindById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public boolean deleteUserById(String id) {
        userRepository.deleteById(id);
        return true;
    }

    public UserEntity userUpdate(UserModel user, String id) {
        user.setId(id);
        return userRepository.save(UserMapper.mapToEntity(user));
    }

}
