package com.africa.semicolon.blog.dto.utility.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CreatePostResponse {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String id;

}
