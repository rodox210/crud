package com.rodd331.crud.v1;

import com.rodd331.crud.impl.facade.UserFacade;
import com.rodd331.crud.v1.mapper.UserContractMapper;
import com.rodd331.crud.v1.mapper.UserListMapper;
import com.rodd331.crud.v1.model.request.UserRequest;
import com.rodd331.crud.v1.model.response.UserListResponse;
import com.rodd331.crud.v1.model.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserContractFacade {

    private UserFacade userFacade;

    UserResponse create(UserRequest user) {
        return UserContractMapper
                .mapToContract(userFacade.create(UserContractMapper.mapToImpl(user)));
    }

    UserListResponse allUsers() {
        return UserListMapper
                .mapUserListToResponse(userFacade.allUsers());
    }

    UserResponse findById(String id) {
        return UserContractMapper
                .mapToContract(userFacade.findById(id));
    }

    UserResponse update(UserRequest user, String id) {
        return UserContractMapper
                .mapToContract(userFacade.update(UserContractMapper
                        .mapToImpl(user), id));
    }

    void delete(String id) {
        userFacade.delete(id);
    }
}
