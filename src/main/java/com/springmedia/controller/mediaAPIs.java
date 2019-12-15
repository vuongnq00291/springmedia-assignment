package com.springmedia.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmedia.pojo.Post;
import com.springmedia.pojo.User;
import com.springmedia.service.MediaService;

@RestController
public class mediaAPIs {
	
	@Autowired
	private MediaService service;
	
	@RequestMapping(value="/post-by-user/{userId}",method=RequestMethod.GET)
	public User getUser(@PathVariable("userId") int userId) throws Throwable{
		
		CompletableFuture<User> userfuture = service.findUser(userId);
		CompletableFuture<List<Post>> postfuture = service.findPost(userId);
		User user = userfuture.get();
		List<Post> posts = postfuture.get();
		user.setPost(posts);
		return user;
		
	}

}
