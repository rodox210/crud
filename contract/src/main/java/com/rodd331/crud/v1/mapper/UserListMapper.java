package com.rodd331.crud.v1.mapper;

import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.v1.model.response.UserListResponse;
import com.rodd331.crud.v1.model.response.UserResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class UserListMapper {

    public static UserListResponse mapUserListToResponse(List<UserModel> userList) {
        @NotNull List<UserResponse>  collect = userList.stream().map(userModel -> UserResponse.builder()
                .id(userModel.getId())
                .userName(userModel.getUserName())
                .email(userModel.getEmail())
                .userPassword(userModel.getUserPassword())
                .build()).collect(Collectors.toList());
        return Objects.requireNonNull(UserListResponse.builder()
                .userResponseList(collect)
                .size(collect.size())
                .build());
    }

}