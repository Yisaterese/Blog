package com.africa.semicolon.blog.repository;

import com.africa.semicolon.blog.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    List<Post> findPostsBy(String username);
    Post findPostBy(String author);
}
