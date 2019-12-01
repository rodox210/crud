package com.rodd331.crud.v1;

import com.rodd331.crud.v1.model.request.UserRequest;
import com.rodd331.crud.v1.model.response.UserListResponse;
import com.rodd331.crud.v1.model.response.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@Api(value = "Contract Controller")
@RequestMapping(path = "/v1/crud")
@RestController
public class ApiController {

    private UserContractFacade userContractFacade;


    @ApiOperation(value = "Cria um usuario no DB")
    @ApiResponses({
            @ApiResponse(code = 201, message = "User created"),
            @ApiResponse(code = 401, message = "Unauthorized Method"),
            @ApiResponse(code = 403, message = "Method not allowed"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody UserRequest user) {
        return userContractFacade.createUser(user);
    }


    @ApiOperation(value = "Retorna uma lista com todos usuarios.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful Operation", response = UserListResponse.class),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/user")
    public UserListResponse allUsers() {
        return userContractFacade.allUsers();
    }


    @ApiOperation(value = "Consulta usuario pelo ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/user/{id}")
    public UserResponse findById(@PathVariable String id) {
        return userContractFacade.findById(id);
    }


    @ApiOperation(value = "Atualiza um usuario existente.")
    @PutMapping("/user/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Updated User"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updateUser(@Valid @RequestBody UserRequest user, @PathVariable String id) {
        return userContractFacade.userUpdate(user, id);
    }

    @ApiOperation(value = "Deleta um usuario pelo ID.")
    @DeleteMapping("/user/{id}")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Deleted User"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        userContractFacade.deleteById(id);
    }

}
