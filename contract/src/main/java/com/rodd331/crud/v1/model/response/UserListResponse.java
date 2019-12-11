package com.rodd331.crud.v1.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserListResponse {
    private List<UserResponse> userResponseList;
    private int size;
}

