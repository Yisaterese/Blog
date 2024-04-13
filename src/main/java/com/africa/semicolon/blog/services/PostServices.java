package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.CreatePostRequest;
import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.dto.utility.response.AddViewToPostResponse;
import com.africa.semicolon.blog.dto.utility.response.CreatePostResponse;
import com.africa.semicolon.blog.model.Comment;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {
     int numberOfView();
     void createContent();
    CreatePostResponse createPost(CreatePostRequest createPostRequest);
    List<Post> findPostByUsername(String username);
    AddViewToPostResponse addViewToPost(PostRequest postRequest, User viewer);
    void addCommentToPost(Post post, Comment comment);
}
