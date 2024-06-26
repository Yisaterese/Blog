package com.africa.semicolon.blog.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document("user")
public class User {
    @Id
    private String id;
    private String password;
    private String username;
    private String email;
    private List<Post> posts;
    private boolean isLoggedIn;

}
