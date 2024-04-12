package com.africa.semicolon.blog.repository;

import com.africa.semicolon.blog.model.Comment;
import com.africa.semicolon.blog.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
    List<Comment> findCommentBy(Post post);
}
