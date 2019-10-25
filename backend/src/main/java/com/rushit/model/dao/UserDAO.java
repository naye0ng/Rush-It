package com.rushit.model.dao;

import com.rushit.model.vo.User;

public interface UserDAO {
	void insertUser(User user);
	User loginUser(String id, String pw);
	User findUser(String id);
	void updateUser(String id, String nick);
}
