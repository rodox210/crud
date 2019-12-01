package com.rodd331.crud.mapper;

import com.rodd331.crud.model.UserModel;
import com.rodd331.crud.repository.UserEntity;

public class UserMapper {

    public static UserModel mapToModel(UserEntity userEntity) {
        return UserModel.builder()
                .id(userEntity.getId())
                .userName(userEntity.getUserName())
                .email(userEntity.getEmail())
                .userPassword(userEntity.getUserPassword())
                .build();
    }

    public static UserEntity mapToEntity(UserModel userModel) {
        return UserEntity.builder()
                .id(userModel.getId())
                .userName(userModel.getUserName())
                .email(userModel.getEmail())
                .userPassword(userModel.getUserPassword())
                .build();
    }
}