package com.rodd331.crud.v1.mapper;

import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.v1.model.request.UserRequest;
import com.rodd331.crud.v1.model.response.UserResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserContractMapper {

    public static UserResponse mapToContract(UserModel userModel) {
        return UserResponse.builder()
                .id(userModel.getId())
                .userName(userModel.getUserName())
                .email(userModel.getEmail())
                .userPassword(userModel.getUserPassword())
                .build();
    }

    public static UserModel mapToImpl(UserRequest userRequest) {
        return UserModel.builder()
                .userName(userRequest.getUserName())
                .email(userRequest.getEmail())
                .userPassword(userRequest.getUserPassword())
                .build();
    }
}