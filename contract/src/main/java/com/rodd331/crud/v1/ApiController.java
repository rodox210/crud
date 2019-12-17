package com.rodd331.crud.v1;

import com.rodd331.crud.impl.handler.ExceptionResponse;
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

@Api(value = "Api Controller", tags = " Api Crud")
@RequestMapping(path = "/crud/v1")
@RestController
@AllArgsConstructor
public class ApiController {
    private UserContractFacade userContractFacade;

    @ApiOperation(value = "Create new user.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User created"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponse.class)
    })
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody UserRequest user) {
        return userContractFacade.create(user);
    }

    @ApiOperation(value = "List all users.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 404, message = "Not found", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponse.class)
    })
    @GetMapping("/user/page/{page}")
    public UserListResponse listUsers(@PathVariable int page) {
        return userContractFacade.allUsers(page);
    }

    @ApiOperation(value = "Search for id.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponse.class)
    })
    @GetMapping("/user/{id}")
    public UserResponse searchForId(@PathVariable String id) {
        return userContractFacade.findById(id);
    }

    @ApiOperation(value = "Update registered user.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Updated User"),
            @ApiResponse(code = 400, message = "Data already registered", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "User not found", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionResponse.class)
    })
    @PutMapping("/user/{id}")
    public @Valid UserResponse update(@Valid @RequestBody UserRequest user, @PathVariable String id) {
        return userContractFacade.update(user, id);
    }

    @ApiOperation(value = "Delete user.")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Deleted User"),
            @ApiResponse(code = 404, message = "User not found", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionResponse.class)
    })
    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        userContractFacade.delete(id);
    }
}
