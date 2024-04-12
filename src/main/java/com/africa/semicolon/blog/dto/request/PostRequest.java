package com.africa.semicolon.blog.dto.request;

import com.africa.semicolon.blog.model.Comment;
import com.africa.semicolon.blog.model.View;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
public class PostRequest {
    private String title;
    private LocalDateTime createdAt;
    private List<Comment> comments = new ArrayList<>();
    @Id
    private String id;
    private  List<View> views = new ArrayList<>();
    private String content;

}
