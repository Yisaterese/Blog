package com.africa.semicolon.blog.dto.request;

import com.africa.semicolon.blog.model.User;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CreatePostRequest {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String author;


}
