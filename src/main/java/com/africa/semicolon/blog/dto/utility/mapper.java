package com.africa.semicolon.blog.dto.utility;

import com.africa.semicolon.blog.dto.utility.response.AddViewToPostResponse;
import com.africa.semicolon.blog.dto.utility.response.CreatePostResponse;
import com.africa.semicolon.blog.dto.utility.response.LoginResponse;
import com.africa.semicolon.blog.dto.utility.response.RegisterResponse;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;

public class mapper {
    public  static RegisterResponse mapRegisterResponse(User user){
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(user.getUsername());
        registerResponse.setEmail(user.getEmail());
        return registerResponse;
    }

    public static CreatePostResponse mapPost(Post post){
        CreatePostResponse createPostResponse = new CreatePostResponse();
        createPostResponse.setTitle(post.getTitle());
        createPostResponse.setContent(post.getContent());
        createPostResponse.setCreatedAt(post.getCreatedAt());
        createPostResponse.setId(post.getId());
        return  createPostResponse;
    }

    public static LoginResponse mapLogin(User user){
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setEmail(user.getEmail());
        loginResponse.setUsername(user.getUsername());
        loginResponse.setId(user.getId());
        loginResponse.setLogin(user.isLoggedIn());
        return loginResponse;
    }

    public static AddViewToPostResponse mapAddViewToPost(){return null;
    }
}
