package com.rodd331.crud.impl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@lombok.Data
@Builder
public class UserModel {

    private String id;
    private String userName;
    private String email;
    private String userPassword;
}