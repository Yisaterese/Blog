package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.dto.utility.response.AddViewToPostResponse;
import com.africa.semicolon.blog.exception.PostNotFoundException;
import com.africa.semicolon.blog.model.Comment;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;
import com.africa.semicolon.blog.model.View;
import com.africa.semicolon.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.africa.semicolon.blog.dto.utility.mapper.mapAddViewToPost;

@Service
public class PostServicesImplementation implements PostServices{
    @Autowired
    private PostRepository postRepository;
    @Autowired
    ViewServices viewServices;
    @Override
    public int numberOfView() {
        return postRepository.findAll().size();
    }
    @Override
    public Post createPost(PostRequest createPostRequest) {
        final Post isExistingPost = getExistingPost(createPostRequest);
        validatePost(isExistingPost);
        Post post = new Post();
        createPostRequest.setTitle(post.getTitle());
        createPostRequest.setContent(post.getContent());
        createPostRequest.setCreatedAt(post.getCreatedAt());
        postRepository.save(post);
        return post;
    }
    private Post getExistingPost(PostRequest createPostRequest) {
        return  postRepository.findPostBy(createPostRequest.getTitle());
    }
    @Override
    public Post findPostByTitle(String username) {
        return postRepository.findPostBy(username);
    }
    @Override
    public AddViewToPostResponse    addViewToPost(PostRequest postRequest, User viewer) {
        Post post = postRepository.findPostBy(postRequest.getTitle());
        validatePost(post);
        View newView = viewServices.createPostView(viewer);
        post.getViews().add(newView);
        postRepository.save(post);
        return mapAddViewToPost();
    }

    private static String validatePost(Post post) {
        try {if (post == null) throw new PostNotFoundException("post not found");
        }catch (PostNotFoundException e){return e.getMessage();}
        return "Post is not found";
    }

    @Override
    public int getNumberOfPosts() {
        return postRepository.findAll().size();
    }

    @Override
    public Post findPostByUser(User foundUser) {
        Post foundPost = postRepository.findPostBy(foundUser);
        validatePost(foundPost);
        return foundPost;
    }
}
