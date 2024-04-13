package com.africa.semicolon.blog.controller;

import com.africa.semicolon.blog.dto.request.CreatePostRequest;
import com.africa.semicolon.blog.dto.request.LoginRequest;
import com.africa.semicolon.blog.dto.request.RegisterRequest;
import com.africa.semicolon.blog.dto.utility.response.ApiResponse;
import com.africa.semicolon.blog.dto.utility.response.CreatePostResponse;
import com.africa.semicolon.blog.dto.utility.response.LoginResponse;
import com.africa.semicolon.blog.dto.utility.response.RegisterResponse;
import com.africa.semicolon.blog.exception.ExistingUserException;
import com.africa.semicolon.blog.exception.IncorrectUsernameException;
import com.africa.semicolon.blog.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {
    @Autowired
    UserServices userServices;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest userRegisterRequest) {
        try {
            RegisterResponse registerResponse = userServices.registerUser(userRegisterRequest);
            return new ResponseEntity<>(new ApiResponse(true, registerResponse), HttpStatus.OK);
        } catch (ExistingUserException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse loginResponse = userServices.login(loginRequest);
            return new ResponseEntity<>(new ApiResponse(true, loginResponse), HttpStatus.OK);
        } catch (IncorrectUsernameException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> createPost(@RequestBody CreatePostRequest createPostRequest) {
        try {
            CreatePostResponse createPostResponse = userServices.createPost(createPostRequest);
            return new ResponseEntity<>(new ApiResponse(true, createPostResponse), HttpStatus.OK);
        } catch (IncorrectUsernameException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
