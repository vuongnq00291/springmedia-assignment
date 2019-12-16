package com.springmedia.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.springmedia.pojo.Post;
import com.springmedia.pojo.User;
import com.springmedia.remote.service.PostService;
import com.springmedia.remote.service.UserService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(properties="spring.config.name=application,remote-services-fail")
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class RemoteServiceTest {
   @Autowired(required=true)
   private PostService postService;
   @Autowired(required=true)
   private UserService userService;
   
   @Test
   public void findUserTest(){
	   User user = userService.getUser(1);
	   assertEquals(user.getId(),0);
	   assertEquals(user.getEmail(),null);
	   
   }
   
   @Test
   public void findPostByUser(){
	   List<Post> post = postService.getPostByUser(1);
	   assertEquals(post.size(),0);
	   
   }
 
   
}