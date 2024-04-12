package com.africa.semicolon.blog.repository;

import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.View;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewRepository extends MongoRepository<View, String> {
    List<View> findViewsBy(Post newPost);
}
