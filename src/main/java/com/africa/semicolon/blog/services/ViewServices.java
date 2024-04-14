package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;
import com.africa.semicolon.blog.model.View;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ViewServices {
    List<View> findViewsByPost(Post newPost);

    View createPostView(User viewer);
}
