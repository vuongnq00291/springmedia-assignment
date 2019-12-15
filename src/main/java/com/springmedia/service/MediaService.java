package com.springmedia.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.springmedia.pojo.Post;
import com.springmedia.pojo.User;
import com.springmedia.remote.service.PostService;
import com.springmedia.remote.service.UserService;

@Service
public class MediaService {

  private static final Logger logger = LoggerFactory.getLogger(MediaService.class);

  
  @Autowired
  private PostService postService;
  
  @Autowired
  private UserService userService;
  
  @Async
  public CompletableFuture<User> findUser(int userid) throws InterruptedException {
	User user =  userService.getUser(userid);
    return CompletableFuture.completedFuture(user);
  }
  
  @Async
  public CompletableFuture<List<Post>> findPostByUser(int userid) throws InterruptedException {
    logger.info("Looking up " + userid);
    List<Post> posts = postService.getPostByUser(userid);
    return CompletableFuture.completedFuture(posts);
  }

}