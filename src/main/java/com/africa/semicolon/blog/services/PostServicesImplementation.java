package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.CreatePostRequest;
import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.dto.utility.response.AddViewToPostResponse;
import com.africa.semicolon.blog.dto.utility.response.CreatePostResponse;
import com.africa.semicolon.blog.model.Comment;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;
import com.africa.semicolon.blog.model.View;
import com.africa.semicolon.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.africa.semicolon.blog.dto.utility.mapper.mapAddViewToPost;
import static com.africa.semicolon.blog.dto.utility.mapper.mapPost;

@Service
public class PostServicesImplementation implements PostServices{
    @Autowired
    private PostRepository postRepository;
    @Autowired
    ViewServices viewServices;
    @Override
    public int numberOfView() {
        return 0;
    }

    @Override
    public void createContent() {

    }

    @Override
    public CreatePostResponse createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        createPostRequest.setTitle(post.getTitle());
        createPostRequest.setContent(post.getContent());
        createPostRequest.setCreatedAt(post.getCreatedAt());
        return mapPost(post);
    }
    @Override
    public List<Post> findPostByUsername(String username) {
        return null;
    }

    @Override
    public AddViewToPostResponse addViewToPost(PostRequest postRequest, User viewer) {
        Post post = postRepository.findPostBy(postRequest.getAuthor());
        View newView = viewServices.
                post.getViews().add(newView);

        return mapAddViewToPost();
    }

    @Override
    public void addCommentToPost(Post post, Comment comment) {

    }
}
