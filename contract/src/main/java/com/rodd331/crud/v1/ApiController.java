package com.rodd331.crud.v1;

import com.rodd331.crud.v1.model.request.UserRequest;
import com.rodd331.crud.v1.model.response.UserListResponse;
import com.rodd331.crud.v1.model.response.UserResponse;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@Api(value = "User")
@RequestMapping(path = "/v1/crud")
@RestController
public class ApiController{


    private UserContractFacade userContractFacade;


    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria um usuario")
    @PostMapping("/user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public UserResponse createUser(@Valid @RequestBody UserRequest user) {
        return userContractFacade.createUser(user);
    }

    @ApiOperation(value = "Retorna todos usuarios.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/user")
    public UserListResponse allUsers() {
        return userContractFacade.allUsers();
    }


    @ApiOperation(value = "Consulta usuario por id.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/user/{id}")
    public UserResponse findById(@PathVariable String id) {
        return userContractFacade.findById(id);
    }


    @ApiOperation(value = "Atualiza usuario existente.")
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

    @ApiOperation(value = "Deleta um usuario.")
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
