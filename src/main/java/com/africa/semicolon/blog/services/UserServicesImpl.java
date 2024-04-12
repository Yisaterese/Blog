package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.RegisterRequest;
import com.africa.semicolon.blog.exception.ExistingUserException.ExistingUserException;
import com.africa.semicolon.blog.model.User;
import com.africa.semicolon.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    UserRepository userRepository;
    @Override
    public void registerUser(RegisterRequest registerRequest) {
        User isExistingUser = userRepository.findByUserName(registerRequest.getUsername());
        if (isExistingUser != null)  throw new ExistingUserException("username taken");
        User newUser = new User();
        newUser.setPassword(registerRequest.getPassword());
        newUser.setUsername(registerRequest.getUsername());
        newUser.setEmail(registerRequest.getEmail());
        userRepository.save(newUser);
    }
}
