package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.CreatePostRequest;
import com.africa.semicolon.blog.dto.request.LoginRequest;
import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.dto.request.RegisterRequest;
import com.africa.semicolon.blog.dto.utility.response.AddViewToPostResponse;
import com.africa.semicolon.blog.dto.utility.response.CreatePostResponse;
import com.africa.semicolon.blog.dto.utility.response.LoginResponse;
import com.africa.semicolon.blog.dto.utility.response.RegisterResponse;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {
    RegisterResponse registerUser(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
    CreatePostResponse createPost(CreatePostRequest createPostRequest);
    int getNumberOfUsers();
    AddViewToPostResponse addViewToPost(PostRequest postRequest, User viewer);
//    void addCommentToPost(Post post, Comment comment);


}
