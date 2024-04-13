package com.africa.semicolon.blog.services;
import com.africa.semicolon.blog.dto.request.CreatePostRequest;
import com.africa.semicolon.blog.dto.request.LoginRequest;
import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.dto.request.RegisterRequest;
import com.africa.semicolon.blog.dto.utility.response.AddViewToPostResponse;
import com.africa.semicolon.blog.dto.utility.response.CreatePostResponse;
import com.africa.semicolon.blog.dto.utility.response.LoginResponse;
import com.africa.semicolon.blog.dto.utility.response.RegisterResponse;
import com.africa.semicolon.blog.exception.*;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;
import com.africa.semicolon.blog.model.View;
import com.africa.semicolon.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.africa.semicolon.blog.dto.utility.mapper.*;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostServices postServices;
    @Autowired
    ViewServices viewServices;
    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        User isExistingUser = userRepository.findByUsername(registerRequest.getUsername());
        if (isExistingUser != null)  throw new ExistingUserException("username taken");
        User newUser = new User();
        newUser.setPassword(registerRequest.getPassword());
        newUser.setUsername(registerRequest.getUsername());
        newUser.setEmail(registerRequest.getEmail());
        userRepository.save(newUser);
        return mapRegisterResponse(newUser);
    }

//    @Override
//    public LoginResponse login(LoginRequest loginRequest) {
//        User foundUser = null;
//        List<User> users = userRepository.findAll();
//        System.out.println(users);
//        for(User user: users){
//            System.out.println(user);
//            if(user.getUsername().equals(loginRequest.getUsername())){
//                foundUser = user;
//                System.out.println(foundUser);
//                foundUser.setUsername(loginRequest.getUsername());
//                foundUser.setEmail(loginRequest.getEmail());
//                foundUser.setLoggedIn(true);
//                userRepository.save(foundUser);
//                return mapLogin(foundUser);
//            }
//        }
//        throw new ExistingUserException("User not found");
//    }

        @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User foundUser = userRepository.findByUsername(loginRequest.getUsername());
        validateNullUser(foundUser);
        validateLoggIn(loginRequest, foundUser);
        setLoginFields(loginRequest, foundUser);
        userRepository.save(foundUser) ;
        return mapLogin(foundUser);
    }

    private static String validateNullUser(User foundUser) {
        try {
            if (foundUser == null) throw new ExistingUserException("user not found");
        }catch (ExistingUserException e){
            return e.getMessage();
        }
        throw new ExistingUserException("user not found ");
    }
    private static void setLoginFields(LoginRequest loginRequest, User isExistingUser) {
        isExistingUser.setUsername(loginRequest.getUsername());
        isExistingUser.setEmail(loginRequest.getEmail());
        isExistingUser.setPassword(loginRequest.getPassword());
        isExistingUser.setLoggedIn(true);
    }
    private static String validateLoggIn(LoginRequest loginRequest, User isExistingUser) {
//        if (isExistingUser != null &&
//                isExistingUser.getUsername().equals(loginRequest.getUsername()) &&
//                isExistingUser.getPassword().equals(loginRequest.getPassword())) {
//                setLoginFields(loginRequest,isExistingUser);
//        }
        try{if(!isExistingUser.getUsername().equals(loginRequest.getUsername())) throw new IncorrectUsernameException("Invalid username");
         }catch (ExistingUserException e){return  e.getMessage();}

        try {if (!isExistingUser.getPassword().equals(loginRequest.getPassword())) throw new InvalidPasswordException("password provided is invalid");
        } catch (InvalidPasswordException e){return e.getMessage();}

        try {if (!isExistingUser.getEmail().equals(loginRequest.getEmail())) throw new InvalidEmailException("Email provided is wrong");
        }catch (InvalidEmailException e){return e.getMessage();}

        throw new InvalidLoginRequestException("Access denied");
    }

    @Override
    public CreatePostResponse createPost(CreatePostRequest createPostRequest) {
        return postServices.createPost(createPostRequest);
    }
    @Override
    public int getNumberOfUsers() {
        return userRepository.findAll().size();
     }

    @Override
    public AddViewToPostResponse addViewToPost(PostRequest postRequest, User viewer) {
        return postServices.addViewToPost(postRequest,viewer);
    }

}
