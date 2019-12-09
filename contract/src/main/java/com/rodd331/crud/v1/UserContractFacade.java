package com.rodd331.crud.v1;

import com.rodd331.crud.impl.facade.UserFacade;
import com.rodd331.crud.v1.mapper.UserContractMapper;
import com.rodd331.crud.v1.mapper.UserListMapper;
import com.rodd331.crud.v1.model.request.UserRequest;
import com.rodd331.crud.v1.model.response.UserListResponse;
import com.rodd331.crud.v1.model.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
@AllArgsConstructor
public class UserContractFacade {

    private UserFacade userFacade;


    UserResponse createUser(UserRequest user) {
        return Objects.requireNonNull(UserContractMapper.mapToContract(userFacade.createUser(UserContractMapper.mapToImpl(user))));
    }
    UserListResponse allUsers() {
        return Objects.requireNonNull(UserListMapper.mapUserListToResponse(userFacade.allUsers()));
    }

    UserResponse findById(String id) {
        return UserContractMapper.mapToContract(userFacade.findById(id));
    }

    UserResponse userUpdate(UserRequest user, String id) {
        return Objects.requireNonNull(UserContractMapper.mapToContract(userFacade.userUpdate(UserContractMapper.mapToImpl(user), id)));
    }

    void deleteById(String id) {
        userFacade.deleteById(id);
    }
}
