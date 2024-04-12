package com.africa.semicolon.blog;

import com.africa.semicolon.blog.dto.request.ViewRequest;
import com.africa.semicolon.blog.dto.request.CommentRequest;
import com.africa.semicolon.blog.dto.request.PostRequest;
import com.africa.semicolon.blog.dto.request.UserRequest;
import com.africa.semicolon.blog.model.Comment;
import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.User;
import com.africa.semicolon.blog.model.View;
import com.africa.semicolon.blog.repository.CommentRepository;
import com.africa.semicolon.blog.repository.PostRepository;
import com.africa.semicolon.blog.repository.ViewRepository;
import com.africa.semicolon.blog.services.CommentServices;
import com.africa.semicolon.blog.services.PostServices;
import com.africa.semicolon.blog.services.ViewServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {
	@Autowired
	private CommentServices commentServices;
	@Autowired
	private ViewServices viewServices;
	@Autowired
	private PostServices postServices;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private ViewRepository viewRepository;

	@AfterEach
	private void cleanUp(){
		commentRepository.deleteAll();
		postRepository.deleteAll();
		viewRepository.deleteAll();
	}

	@Test
	public void addCommentTest(){
		CommentRequest commentRequest = new CommentRequest();
		UserRequest userRequest = new UserRequest();
		PostRequest postRequest = new PostRequest();
		ViewRequest viewRequest =  new ViewRequest();
		Comment comment = new Comment();
		User user = new User();
		Post newPost = new Post();
		View view = new View();


		commentRequest.setCommenter(user);
		commentRequest.setComment("Life sweet sha");
		comment.setComment(commentRequest.getComment());
		comment.setCommenter(commentRequest.getCommenter());
		commentServices.addComment(user,commentRequest);

		 List<Comment> foundComments =  commentServices.findCommentsByPost(newPost);

		viewRequest.setTimeOfView(LocalDateTime.now());
		viewRequest.setViewer(user);
		view.setTimeOfView(viewRequest.getTimeOfView());
		view.setViewer(viewRequest.getViewer());

		List<View> foundViews = viewServices.findViewsByPost(newPost);

		postRequest.setTitle("Chop life");
		postRequest.setContent("life sweet na who no get money no go know");
		postRequest.setCreatedAt(LocalDateTime.now());
		postRequest.setComments(foundComments);
		postRequest.setViews(foundViews);
		newPost.setViews(postRequest.getViews());
		newPost.setTitle(postRequest.getTitle());
		newPost.setContent(postRequest.getContent());
		newPost.setCreatedAt(postRequest.getCreatedAt());
		newPost.setComments(postRequest.getComments());

		List<Post> posts = postServices.findPostByUsername(userRequest.getUsername());

		userRequest.setUsername("MyUsername");
		userRequest.setPassword("password");
		userRequest.setFirstName("MyFirstname");
		userRequest.setLastName("MyLastname");
		userRequest.setPosts(posts);
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setUsername(userRequest.getUsername());
		user.setPassword(userRequest.getPassword());
		user.setPosts(userRequest.getPosts());

		Assertions.assertNotEquals(foundComments,comment);
		System.out.println(foundComments);
		System.out.println(comment);
	}

	@Test
	public void userCreatePostTest() {
		PostRequest postRequest = new PostRequest();
		UserRequest userRequest = new UserRequest();
		CommentRequest commentRequest = new CommentRequest();
		User user = new User();
		Post post = new Post();

		userRequest.setFirstName("Ajibola");
		userRequest.setLastName("Justin");
		userRequest.setPassword("password");
		userRequest.setUsername("MyUsername");

		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setUsername(userRequest.getUsername());
		user.setPosts();
		user.setPassword(userRequest.getPassword());

		//userRequest.setPosts();
		postRequest.setTitle("Chop life");
		postRequest.setContent("life sweet na who no get money no go know");
		postRequest.setCreatedAt(LocalDateTime.now());
		postRequest.setComments();

		commentRequest.setComment("I tell you...");
		commentRequest.setCommenter(user);
	}

}
