package com.africa.semicolon.blog.dto.request;

import lombok.Data;

@Data
public class CreatePostRequests {
    private PostRequest postRequest;
    private UserRegisterRequest userRegisterRequest;
}
