package com.rodd331.crud.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UserEntity {

    private String id;
    private String userName;
    private String email;
    private String userPassword;


}
