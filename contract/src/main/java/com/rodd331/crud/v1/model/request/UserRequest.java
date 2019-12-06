package com.rodd331.crud.v1.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@lombok.Data
public class UserRequest {


    @NotBlank
    @Size(min = 4, max = 20, message = "min 4 max 20 Caracteres")
    private String userName;

    @NotBlank
    @Email(message = "Invalid email")
    private String email;

    @NotBlank
    @Size(min = 3, max = 20, message = "min 3 max 20 Caracteres")
    private String userPassword;

}
