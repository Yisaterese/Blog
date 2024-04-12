package com.africa.semicolon.blog.dto.request;

import com.africa.semicolon.blog.model.User;
import lombok.Data;

@Data
public class CommentRequest {
    private String id;
    private User commenter;
    private String comment;
}
