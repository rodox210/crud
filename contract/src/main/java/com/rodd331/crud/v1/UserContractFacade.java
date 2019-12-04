package com.rodd331.crud.v1;

import com.rodd331.crud.UserFacade;
import com.rodd331.crud.v1.model.request.UserRequest;
import com.rodd331.crud.v1.model.response.UserListResponse;
import com.rodd331.crud.v1.model.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.rodd331.crud.v1.mapper.UserListMapper.mapUserListToResponse;
import static com.rodd331.crud.v1.mapper.UserMapper.mapToContract;
import static com.rodd331.crud.v1.mapper.UserMapper.mapToImpl;

@AllArgsConstructor
@Component
public class UserContractFacade {

    private UserFacade userFacade;

    UserResponse createUser(UserRequest user){
        return mapToContract(userFacade.createUser(mapToImpl(user)));
    }

    UserListResponse allUsers() {

        return mapUserListToResponse(userFacade.allUsers());
    }

    UserResponse findById(String id) {
        return mapToContract(userFacade.findById(id));
    }

    UserResponse userUpdate(UserRequest user, String id) {
        return mapToContract(userFacade.userUpdate(mapToImpl(user), id));
    }

    void deleteById(String id) {
        userFacade.deleteById(id);
    }
}
