package com.africa.semicolon.blog.dto.utility.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String id;
    private String username;
    private boolean login;
}
