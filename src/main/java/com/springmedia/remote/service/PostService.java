package com.springmedia.remote.service;

import java.util.List;

import com.springmedia.pojo.Post;
import com.springmedia.remote.IRemote;
import com.springmedia.remote.RemoteService;

@RemoteService(name="post")
public interface PostService extends IRemote{
	 List<Post> getPostByUser(int userId);
}
