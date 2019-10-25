package com.rushit.model.service;

import com.rushit.model.vo.User;

public interface UserService {
	
	
	User addUser(User user);
	User loginUser(String id, String pw);
	User findUser(String id);
	User updateUser(String id, String nick);
}
