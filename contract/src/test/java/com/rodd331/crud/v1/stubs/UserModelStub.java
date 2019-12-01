package com.rodd331.crud.v1.stubs;

import com.rodd331.crud.model.UserModel;

public class UserModelStub {

    public static UserModel generationUserModel() {
        return UserModel.builder()
                .id("someid")
                .userName("teste")
                .email("teste@live.com")
                .userPassword("123456")
                .build();
    }

    public static UserModel generationUserModel2() {
        return UserModel.builder()
                .id("someid")
                .userName("Chapolin")
                .email("chapolin@live.com")
                .userPassword("123456")
                .build();
    }
}