package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {
    void registerUser(RegisterRequest registerRequest);
}
