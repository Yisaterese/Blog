package com.africa.semicolon.blog.dto.request;

import com.africa.semicolon.blog.model.User;
import lombok.Data;

@Data
public class AddCommentResponse {
    private String id;
    private UserRegisterRequest userRegisterRequest;
    private String comment;
}
