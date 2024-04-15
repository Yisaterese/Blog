package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.*;
import com.africa.semicolon.blog.dto.utility.response.AddViewToPostResponse;
import com.africa.semicolon.blog.dto.utility.response.CreatePostResponse;
import com.africa.semicolon.blog.dto.utility.response.LoginResponse;
import com.africa.semicolon.blog.dto.utility.response.RegisterResponse;
import com.africa.semicolon.blog.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {
    RegisterResponse registerUser(UserRegisterRequest userRequest);
    LoginResponse login(LoginRequest loginRequest);
    CreatePostResponse createUserPost(PostRequest postRequest, UserRegisterRequest userRequest);
    int getNumberOfUsers();
    AddViewToPostResponse addViewToPost(PostRequest postRequest, UserRegisterRequest registerRequest);
    int getNumberOfPosts();
    User findByUsername(String username);
    DeletePostResponse deletePost(PostRequest postRequest, UserRegisterRequest userRegisterRequest);
    AddCommentResponse addCommentToPost(UserRegisterRequest post, CommentRequest comment);


}
