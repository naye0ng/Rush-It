package com.rushit.model.dao;

import java.util.List;

import com.rushit.model.vo.User;

public interface UserDAO {
	User loginUser(User user);
	List<User> findAllUsers();
	User findUserById(String id);
	Boolean insertUser(User user);
	Boolean updateUser(User user);
	Boolean deleteUser(User user);
}
