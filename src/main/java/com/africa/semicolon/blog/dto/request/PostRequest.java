package com.africa.semicolon.blog.dto.request;

import com.africa.semicolon.blog.model.Comment;
import com.africa.semicolon.blog.model.View;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostRequest {
    private String id;
    private String title;
    private LocalDateTime createdAt;
    private String content;
    private List<Comment> comments = new ArrayList<>();
    private  List<View> views = new ArrayList<>();
}
