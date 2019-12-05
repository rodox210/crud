package com.rodd331.crud.stubs;

import com.rodd331.crud.impl.repository.UserEntity;

public class UserEntityStub {

    public static UserEntity generationUserEntity() {
        return UserEntity.builder()
                .id("someid")
                .userName("teste")
                .email("teste@live.com")
                .userPassword("123456")
                .build();
    }

    public static UserEntity generationUserEntity2() {
        return UserEntity.builder()
                .id("genericId2")
                .userName("Chapolin")
                .email("chapolin@live.com")
                .userPassword("123456")
                .build();
    }

}