package Study.spring.boot.CauTrucChuan.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Study.spring.boot.CauTrucChuan.common.ApiResponse;
import Study.spring.boot.CauTrucChuan.common.BaseController;
import Study.spring.boot.CauTrucChuan.dto.record.UserRp;
import Study.spring.boot.CauTrucChuan.dto.record.UserRq;
import Study.spring.boot.CauTrucChuan.dto.request.UserRequest;
import Study.spring.boot.CauTrucChuan.dto.response.UserResponse;
import Study.spring.boot.CauTrucChuan.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UserController extends BaseController{
      private final UserService usersv;
      
      @GetMapping
      public ApiResponse<List<UserRp>> showUsers(){
    	  return createSuccessResponse(usersv.index());
      }
      @PostMapping
      public ApiResponse<String> createNewUser(@Valid @RequestBody UserRq userRq) {
    	    usersv.create(userRq);
    	    return createSuccessResponse("Create a new user successfully");
    	}

    	@PutMapping("/{id}")
    	public ApiResponse<String> updateUser(@PathVariable("id") String id, @RequestBody UserRq userRq) {
    		usersv.update(id, userRq);
    	    return createSuccessResponse("Update a user successfully");
    	}

    	@DeleteMapping("/{id}")
    	public ApiResponse<String> deleteUser(@PathVariable("id") String id) {
    		usersv.delete(id);
    	    return createSuccessResponse("Delete a user successfully");
    	}
}
