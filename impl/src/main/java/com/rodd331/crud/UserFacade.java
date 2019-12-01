package com.rodd331.crud;

import com.rodd331.crud.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.rodd331.crud.mapper.UserMapper.mapToModel;

@Component
@AllArgsConstructor
public class UserFacade {

    private UserService userService;


    public UserModel createUser(UserModel user) {

        return mapToModel(userService.createUser(user));
    }


    public List<UserModel> allUsers() {

        return userService.allUsers();
    }


    public UserModel findById(String id) {

        return mapToModel(userService.findById(id));
    }


    public UserModel userUpdate(UserModel user, String id) {

        return mapToModel(userService.userUpdate(user, id));
    }

    public void deleteById(String id)  {
        userService.deleteUserById(id);
    }
}