package com.africa.semicolon.blog.dto.request;

import com.africa.semicolon.blog.model.Post;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String username;
    private List<Post> posts;
    @Id
    private String id;
    private String password;
}
