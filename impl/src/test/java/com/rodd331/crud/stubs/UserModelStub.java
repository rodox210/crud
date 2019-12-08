package com.rodd331.crud.stubs;

import com.rodd331.crud.impl.model.UserModel;

public class UserModelStub {

    public static UserModel generationUserModel() {
        return UserModel.builder()
                .id("someid")
                .userName("teste")
                .email("teste@live.com")
                .userPassword("123456")
                .build();
    }
}