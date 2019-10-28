package com.rushit.model.dao;

import com.rushit.model.vo.User;

public interface UserDAO {
	Boolean insertUser(User user);
	User loginUser(User user);
	void updateUser(User user);
	User findUser(String id);
	Boolean deleteUser(User user);
}
