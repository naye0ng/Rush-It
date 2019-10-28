package com.rushit.model.service;

import com.rushit.model.vo.User;

public interface UserService {
	
	
	Boolean addUser(User user);
	User loginUser(User user);
	User findUser(String id);
	User updateUser(User user);
	Boolean deleteUser(User user);
}
