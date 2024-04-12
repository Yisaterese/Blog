package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.CommentRequest;
import com.africa.semicolon.blog.model.Comment;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;
import com.africa.semicolon.blog.dto.request.UserRequest;
import com.africa.semicolon.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServicesImple implements CommentServices {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public String findById() {
        return null;
    }
    @Override
    public int numberOfComments() {
        return 0;
    }
    @Override
    public User commenter(UserRequest userRequest) {
        return null;
    }

    @Override
    public void addComment(UserRequest userRequest, CommentRequest commentRequest) {

    }
    @Override
    public void addComment(User user, CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        comment.setCommenter(user);
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        commentRepository.save(comment);



    }

    @Override
    public List<Comment> findCommentsByPost(Post post) {
        return commentRepository.findCommentBy(post);
    }
}
