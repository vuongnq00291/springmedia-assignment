package com.springmedia.remote.service;

import com.springmedia.pojo.User;
import com.springmedia.remote.IRemote;
import com.springmedia.remote.RemoteService;

@RemoteService(name="user")
public interface UserService extends IRemote{
	 User getUser(int userId);
}
