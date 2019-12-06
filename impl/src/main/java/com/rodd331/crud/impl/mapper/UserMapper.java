package com.rodd331.crud.impl.mapper;

import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.repository.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

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