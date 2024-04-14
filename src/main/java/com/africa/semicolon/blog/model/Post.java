package com.africa.semicolon.blog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Document("Post")
public class Post {
    @Id
    private String id;
    private String title;
    private LocalDateTime createdAt;
    private String content;
    private List<Comment> comments = new ArrayList<>();
    private  List<View> views = new ArrayList<>();

}
