package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.LoginRequest;
import com.africa.semicolon.blog.dto.request.UserRegisterRequest;
import com.africa.semicolon.blog.dto.utility.response.LoginResponse;
import com.africa.semicolon.blog.exception.ExistingUserException;
import com.africa.semicolon.blog.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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

        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUsername("Joseph");
        userRegisterRequest.setPassword("MyPassword");
        userRegisterRequest.setEmail("joseph@gmail.com");
        userServices.registerUser(userRegisterRequest);
        Assertions.assertEquals(1,userServices.getNumberOfUsers());
    }

    @Test
    public void registerTwoUsersWithSameUsername_throwsExceptionTest(){

        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUsername("Joseph");
        userRegisterRequest.setPassword("MyPassword");
        userRegisterRequest.setEmail("joseph@gmail.com");
        userServices.registerUser(userRegisterRequest);
        Assertions.assertEquals(1,userServices.getNumberOfUsers());


        userRegisterRequest.setUsername("Joseph");
        userRegisterRequest.setPassword("MyPassword");
        userRegisterRequest.setEmail("joseph@gmail.com");
        Assertions.assertThrows( ExistingUserException.class, ()->  userServices.registerUser(userRegisterRequest));
    }

    @Test
    public void userLoginTest(){

        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUsername("Joseph");
        userRegisterRequest.setPassword("MyPassword");
        userRegisterRequest.setEmail("joseph@gmail.com");
        userServices.registerUser(userRegisterRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(userRegisterRequest.getUsername());
        loginRequest.setPassword(userRegisterRequest.getPassword());
        LoginResponse loginResponse = userServices.login(loginRequest);

        Assertions.assertNotNull(loginResponse.getId());
        Assertions.assertTrue(loginResponse.isLogin());
    }
    @Test
    public void userLoginWithWrongUsername_ThrowsExceptionTest(){
       UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUsername("Joseph");
        userRegisterRequest.setPassword("MyPassword");
        userRegisterRequest.setEmail("joseph@gmail.com");
        userServices.registerUser(userRegisterRequest);

        LoginRequest loginRequest = new LoginRequest();

        String wrongUsername = "wrongUsername";
        loginRequest.setUsername(wrongUsername);
        loginRequest.setPassword(userRegisterRequest.getPassword());

        Assertions.assertThrows(NullPointerException.class, ()->  userServices.login(loginRequest));
    }
}