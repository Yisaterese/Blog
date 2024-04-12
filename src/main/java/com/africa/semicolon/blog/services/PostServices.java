package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {
     int numberOfView();
     void createContent();
    List<Post> findPostByUsername(String username);
}
