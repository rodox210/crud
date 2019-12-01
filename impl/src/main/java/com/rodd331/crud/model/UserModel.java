package com.rodd331.crud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UserModel {

    private String id;
    private String userName;
    private String email;
    private String userPassword;
}