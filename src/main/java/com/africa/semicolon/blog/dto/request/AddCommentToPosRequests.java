package com.africa.semicolon.blog.dto.request;

import lombok.Data;

@Data
public class AddCommentToPosRequests {
    private UserRegisterRequest userRegisterRequest;
    private CommentRequest commentRequest;
}
