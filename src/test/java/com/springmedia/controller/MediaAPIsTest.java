package com.springmedia.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmedia.pojo.Post;
import com.springmedia.pojo.User;
import com.springmedia.service.MediaService;
@RunWith(SpringRunner.class)
public class MediaAPIsTest {
	private MockMvc mockMvc;
	@Mock
	private MediaService service;
	@InjectMocks
	private mediaAPIs controller;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
	            .build();
	}

	@Test
	public void getAllModules() throws Exception {
		
		User user = new User();
		user.setUsername("test1");
		user.setWebsite("spring-media.com");
		user.setId(1);
		Post post = new Post();
		post.setId(1);
		post.setTitle("post1");
		post.setBody("something here");
		List<Post> posts = new ArrayList<Post>();
		posts.add(post);
		
		when(service.findPostByUser(1)).thenReturn(CompletableFuture.completedFuture(posts));
		when(service.findUser(1)).thenReturn(CompletableFuture.completedFuture(user));
		
		MvcResult result = mockMvc.perform(get("/post-by-user/1"))
	            .andExpect(status().isOk())
				.andReturn();
		
		ObjectMapper mapper = new ObjectMapper();
		User res = mapper.readValue(result.getResponse().getContentAsString(),User.class);
		assertEquals(res.getUsername(), "test1");
		assertEquals(res.getPost().size(), 1);
	}
	

}
