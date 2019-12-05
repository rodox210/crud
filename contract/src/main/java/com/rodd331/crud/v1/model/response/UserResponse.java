package com.rodd331.crud.v1.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
@Builder
public class UserResponse {

    private String id;
    private String userName;
    private String email;
    private String userPassword;

}
