package com.rodd331.crud.impl.facade;

import com.rodd331.crud.impl.model.UserModel;
import com.rodd331.crud.impl.service.PersistenceService;
import com.rodd331.crud.impl.service.ValidationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.rodd331.crud.impl.mapper.UserMapper.mapToEntity;
import static com.rodd331.crud.impl.mapper.UserMapper.mapToModel;

@Component
@AllArgsConstructor
public class UserFacade {

    private PersistenceService persistenceService;
    private ValidationService validationService;

    public UserModel createUser(UserModel user) {

        validationService.checkForResgistredExistenceInDataBaseName(user);

        validationService.checkForResgistredExistenceInDataBaseEmail(user);
        return mapToModel(persistenceService.createUser(mapToEntity(user)));
    }


    public List<UserModel> allUsers() {
        validationService.validationEmptyList();
        return persistenceService.listAllUsersReturn();
    }


    public UserModel findById(String id) {
        return mapToModel(persistenceService.userFindById(id));
    }


    public UserModel userUpdate(UserModel user, String id) {
        validationService.validatorUserId(id);
        user.setId(id);
        return mapToModel(persistenceService.userUpdate(mapToEntity(user)));
    }

    public void deleteById(String id) {
        validationService.validatorUserId(id);
        persistenceService.deleteUserById(id);
    }
}