package com.springmedia.config;

import java.lang.reflect.InvocationHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.springmedia.remote.RemoteServiceProxy;
import com.springmedia.remote.service.PostService;
import com.springmedia.remote.service.UserService;

@Component
public class BeanRegistration {

	@Autowired
	private RemoteServiceProxy clproxy;
	
	@Bean
    public PostService postService() {
        return clproxy.NewBuilderProxy(PostService.class);
    }
	
	@Bean
    public UserService userService() {
        return clproxy.NewBuilderProxy(UserService.class);
    }

	public InvocationHandler getClproxy() {
		return clproxy;
	}

	public void setClproxy(RemoteServiceProxy clproxy) {
		this.clproxy = clproxy;
	}
}
