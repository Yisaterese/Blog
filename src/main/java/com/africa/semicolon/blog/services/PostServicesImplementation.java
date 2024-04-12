package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServicesImplementation implements PostServices{
    @Autowired
    private PostRepository postRepository;
    @Override
    public int numberOfView() {
        return 0;
    }

    @Override
    public void createContent() {

    }

    @Override
    public List<Post> findPostByUsername(String username) {
        return null;
    }
}
