package com.africa.semicolon.blog.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String password;
    private String username;
    private String email;
}
