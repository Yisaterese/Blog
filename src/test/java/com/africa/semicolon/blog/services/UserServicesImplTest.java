package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.LoginRequest;
import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.dto.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class UserServicesImplTest {
@Autowired
UserServices userServices;
    @Test
    public void createPostTest(){
        PostRequest postRequest = new PostRequest();
        RegisterRequest registerRequest = new RegisterRequest();


        registerRequest.setUsername("Joseph");
        registerRequest.setPassword("MyPassword");
        registerRequest.setEmail("joseph@gmail.com");
        userServices.registerUser(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(registerRequest.getUsername());
        loginRequest.setPassword(registerRequest.getPassword());





    }
}