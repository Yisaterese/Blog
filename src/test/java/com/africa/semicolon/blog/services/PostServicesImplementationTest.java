package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.UserRegisterRequest;
import com.africa.semicolon.blog.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostServicesImplementationTest {
    @Autowired
    UserServices userServices;
    @Autowired
    UserRepository userRepository;
    private  UserRegisterRequest userRegisterRequest;
    @BeforeEach
    private void setUp(){
        userRegisterRequest = new UserRegisterRequest();

    }
    private void cleanUp(){
        userRepository.deleteAll();
    }
    @Test
    public void createPostTest(){
        userRegisterRequest.setUsername("Ada");
        userRegisterRequest.setPassword("MyPassword");
        userRegisterRequest.setEmail("ada@gmail.com");
        userServices.registerUser(userRegisterRequest);
        Assertions.assertEquals(1,userServices.getNumberOfUsers());

    }


}