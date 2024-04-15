package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.dto.utility.response.AddViewToPostResponse;
import com.africa.semicolon.blog.model.Comment;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;
import org.springframework.stereotype.Service;

@Service
public interface PostServices {
     int numberOfView();
    Post createPost(PostRequest postRequest);
    Post findPostByTitle(String username);
    AddViewToPostResponse addViewToPost(PostRequest postRequest, User viewer);
    int getNumberOfPosts();

    Post findPostByUser(User foundUser);
}
