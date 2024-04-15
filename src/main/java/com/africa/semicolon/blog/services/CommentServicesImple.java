package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.CommentRequest;
import com.africa.semicolon.blog.model.Comment;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;
import com.africa.semicolon.blog.dto.request.UserRegisterRequest;
import com.africa.semicolon.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Comment creatComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        comment.setId(commentRequest.getId());
        return comment;
    }
    @Override
    public List<Comment> findCommentsByPost(Post post) {
        return commentRepository.findCommentBy(post);
    }
}
