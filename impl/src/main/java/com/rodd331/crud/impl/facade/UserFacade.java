package com.rodd331.crud.impl.facade;

import com.rodd331.crud.impl.mapper.UserMapper;
import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.service.PersistenceService;
import com.rodd331.crud.impl.service.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserFacade {

    private PersistenceService persistenceService;
    private ValidationService validationService;

    public UserModel createUser(UserModel user) {
        validationService.checkForResgistredExistenceInDataBaseName(user);
        validationService.checkForResgistredExistenceInDataBaseEmail(user);
        return UserMapper.mapToModel(persistenceService.createUser(user));
    }


    public List<UserModel> allUsers() {
        validationService.validationEmptyList();
        return persistenceService.listAllUsersReturn();
    }


    public UserModel findById(String id) {
        return UserMapper.mapToModel(persistenceService.userFindById(id));
    }


    public UserModel userUpdate(UserModel user, String id) {
        validationService.validatorUserId(id);
        return UserMapper.mapToModel(persistenceService.userUpdate(user, id));
    }

    public void deleteById(String id) {
        validationService.validatorUserId(id);
        persistenceService.deleteUserById(id);
    }
}