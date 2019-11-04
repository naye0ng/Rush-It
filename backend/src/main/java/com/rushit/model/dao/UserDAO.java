package com.rushit.model.dao;

import java.util.HashMap;
import java.util.List;

import com.rushit.model.vo.User;

public interface UserDAO {
	HashMap<String, String> loginUser(User user);
	List<User> findAllUsers();
	User findUserById(String id);
	Boolean insertUser(User user);
	Boolean updateUser(User user);
	Boolean deleteUser(User user);
}
