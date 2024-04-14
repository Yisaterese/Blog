package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.LoginRequest;
import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.dto.request.UserRegisterRequest;
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
    //CreatePostResponse createUserPost(PostRequest createPostRequest, User user);
    int getNumberOfUsers();
    AddViewToPostResponse addViewToPost(PostRequest postRequest, User viewer);
    AddViewToPostResponse addViewToPost(PostRequest postRequest, UserRegisterRequest registerRequest);

    int getNumberOfPosts();
    User findByUsername(String username);
//    void addCommentToPost(Post post, Comment comment);


}
