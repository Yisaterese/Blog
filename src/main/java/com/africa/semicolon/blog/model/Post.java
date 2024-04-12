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
    private String title;
    private LocalDateTime createdAt;
    private List<Comment> comments = new ArrayList<>();
    @Id
    private String id;
    private  List<View> views = new ArrayList<>();
    private String content;

}
