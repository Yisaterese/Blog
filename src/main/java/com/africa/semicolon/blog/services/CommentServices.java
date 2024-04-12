package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.CommentRequest;
import com.africa.semicolon.blog.model.Comment;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;
import com.africa.semicolon.blog.dto.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentServices {
    String findById();
    int numberOfComments();
    User commenter(UserRequest userRequest);
    void addComment(UserRequest userRequest, CommentRequest commentRequest);

    void addComment(User user, CommentRequest commentRequest);

    List<Comment> findCommentsByPost(Post post);
}
