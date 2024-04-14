package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.dto.request.LoginRequest;
import com.africa.semicolon.blog.dto.request.UserRegisterRequest;
import com.africa.semicolon.blog.dto.utility.response.CreatePostResponse;
import com.africa.semicolon.blog.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class PostServicesImplementationTest {
    @Autowired
    UserServices userServices;
    @Autowired
    PostRepository postRepository;
    
    @Autowired
    PostServices postServices;

    @AfterEach
    private void cleanUp() {
        postRepository.deleteAll();
    }

    @Test
    public void createPostTest() {

        UserRegisterRequest userRequest = new UserRegisterRequest();
        userRequest.setUsername("JosephYisa");
        userRequest.setPassword("MyPassword");
        userRequest.setEmail("joseph@gmail.com");
        userServices.registerUser(userRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(userRequest.getUsername());
        loginRequest.setPassword(userRequest.getPassword());
        userServices.login(loginRequest);

        PostRequest postRequest = new PostRequest();
        postRequest.setTitle("Life sweet");
        postRequest.setContent("Na who no get money no go know");
        postRequest.setCreatedAt(LocalDateTime.now());
        CreatePostResponse createPostResponse = userServices.createUserPost(postRequest,userRequest);
        System.out.println(createPostResponse);

        Assertions.assertNotNull(createPostResponse.getId());
        Assertions.assertEquals(1, postRepository.count());
    }
//   // @Test
//    public void AddCommentToPost(){
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setUsername("Joseph");
//        registerRequest.setPassword("MyPassword");
//        registerRequest.setEmail("joseph@gmail.com");
//        userServices.registerUser(registerRequest);
//
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername(registerRequest.getUsername());
//        loginRequest.setPassword(registerRequest.getPassword());
//        userServices.login(loginRequest);
//
//        PostRequest postRequest = new PostRequest();
//        postRequest.setTitle("Life sweet");
//        postRequest.setContent("Na who no get money no go know");
//        postRequest.setCreatedAt(LocalDateTime.now());
//        CreatePostResponse createPostResponse = userServices.createUserPost(postRequest);
//        Assertions.assertNotNull(createPostResponse.getId());
//
//       User viewer = userServices.findByUsername(registerRequest.getUsername());
//        postServices.addViewToPost(postRequest,viewer);
//        Assertions.assertTrue(postRequest.getViews().contains(viewer));
//
//    }
}

