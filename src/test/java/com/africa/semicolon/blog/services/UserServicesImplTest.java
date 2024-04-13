package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.CreatePostRequest;
import com.africa.semicolon.blog.dto.request.LoginRequest;
import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.dto.request.RegisterRequest;
import com.africa.semicolon.blog.dto.utility.response.LoginResponse;
import com.africa.semicolon.blog.exception.ExistingUserException;
import com.africa.semicolon.blog.exception.InvalidPasswordException;
import com.africa.semicolon.blog.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@SpringBootTest
class UserServicesImplTest {
    @Autowired
    UserServices userServices;
    @Autowired
    UserRepository userRepository;

    @AfterEach
    private void cleanUp(){
        userRepository.deleteAll();
    }
    @Test
    public void registerUserTest(){

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("Joseph");
        registerRequest.setPassword("MyPassword");
        registerRequest.setEmail("joseph@gmail.com");
        userServices.registerUser(registerRequest);
        Assertions.assertEquals(1,userServices.getNumberOfUsers());
    }

    @Test
    public void registerTwoUsersWithSameUsername_throwsExceptionTest(){

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("Joseph");
        registerRequest.setPassword("MyPassword");
        registerRequest.setEmail("joseph@gmail.com");
        userServices.registerUser(registerRequest);
        Assertions.assertEquals(1,userServices.getNumberOfUsers());


        registerRequest.setUsername("Joseph");
        registerRequest.setPassword("MyPassword");
        registerRequest.setEmail("joseph@gmail.com");
        Assertions.assertThrows( ExistingUserException.class, ()->  userServices.registerUser(registerRequest));
    }

    @Test
    public void userLoginTest(){

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("Joseph");
        registerRequest.setPassword("MyPassword");
        registerRequest.setEmail("joseph@gmail.com");
        userServices.registerUser(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(registerRequest.getUsername());
        loginRequest.setPassword(registerRequest.getPassword());
        LoginResponse loginResponse = userServices.login(loginRequest);

        Assertions.assertNotNull(loginResponse.getId());
        Assertions.assertTrue(loginResponse.isLogin());
    }
    @Test
    public void userLoginWithWrongUsername_ThrowsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("Joseph");
        registerRequest.setPassword("MyPassword");
        registerRequest.setEmail("joseph@gmail.com");
        userServices.registerUser(registerRequest);

        LoginRequest loginRequest = new LoginRequest();

        String wrongUsername = "wrongUsername";
        loginRequest.setUsername(wrongUsername);
        loginRequest.setPassword(registerRequest.getPassword());

        Assertions.assertThrows(ExistingUserException.class, ()->  userServices.login(loginRequest));
    }
   // @Test
    public void createPostTest(){

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("Joseph");
        registerRequest.setPassword("MyPassword");
        registerRequest.setEmail("joseph@gmail.com");
        userServices.registerUser(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(registerRequest.getUsername());
        loginRequest.setPassword(registerRequest.getPassword());
        userServices.login(loginRequest);

        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("Life sweet");
        createPostRequest.setContent("Na who no get money no go know");
        createPostRequest.setCreatedAt(LocalDateTime.now());
        userServices.createPost(createPostRequest);






    }
}