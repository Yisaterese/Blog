package com.africa.semicolon.blog.controller;

import com.africa.semicolon.blog.dto.request.*;
import com.africa.semicolon.blog.dto.utility.response.*;
import com.africa.semicolon.blog.exception.ExistingUserException;
import com.africa.semicolon.blog.exception.IncorrectUsernameException;
import com.africa.semicolon.blog.exception.NotUserPostException;
import com.africa.semicolon.blog.exception.PostNotFoundException;
import com.africa.semicolon.blog.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {
    @Autowired
    UserServices userServices;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequest userRegisterRequest) {
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
    @PostMapping("/createPost")
    public ResponseEntity<?> createPost(@RequestBody CreatePostRequests postRequests) {
        try {
            CreatePostResponse createPostResponse = userServices.createUserPost(postRequests.getPostRequest(), postRequests.getUserRegisterRequest());
            return new ResponseEntity<>(new ApiResponse(true, createPostResponse), HttpStatus.OK);
        } catch (IncorrectUsernameException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deletePost")
    public ResponseEntity<?> deletePost(@PathVariable DeletePostRequests deletePostRequests){
        try{
            DeletePostResponse deletePostResponse = userServices.deletePost(deletePostRequests.getPostRequest(),deletePostRequests.getUserRegisterRequest());
            return new ResponseEntity<>(new ApiResponse(true,deletePostResponse),HttpStatus.OK);
        }catch (NotUserPostException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/addCommentToPost")
    public ResponseEntity<?>addCommentToPost(AddCommentToPosRequests addCommentToPosRequests){
        try{
            AddCommentResponse addCommentResponse = userServices.addCommentToPost(addCommentToPosRequests.getUserRegisterRequest(),addCommentToPosRequests.getCommentRequest());
            return new ResponseEntity<>(new ApiResponse(true,addCommentResponse),HttpStatus.OK);
        }catch (PostNotFoundException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/addViewsToPost")
    public ResponseEntity<?> addViewsToPost(AddViewRequests addViewRequests){
        try{
            AddViewToPostResponse addViewToPostResponse = userServices.addViewToPost(addViewRequests.getPostRequest(),addViewRequests.getUserRegisterRequest());
            return new ResponseEntity<>(new ApiResponse(true,addViewToPostResponse),HttpStatus.OK);
        }catch (PostNotFoundException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.BAD_REQUEST);
        }

    }
}
