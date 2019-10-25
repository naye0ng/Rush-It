package com.rushit.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushit.model.dao.UserDAO;
import com.rushit.model.vo.User;

@Service
public class UserServiceImpl implements UserService {


	private UserDAO userDao;
	
	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User addUser(User user) {
		userDao.insertUser(user);
		return userDao.loginUser(user.getId(), user.getPw());
	}

	@Override
	public User loginUser(String id, String pw) {
		return userDao.loginUser(id, pw);
	}

	@Override
	public User updateUser(String id, String nick) {
		userDao.updateUser(id, nick);
		return userDao.findUser(id);
	}

	@Override
	public User findUser(String id) {
		System.out.println();
		return userDao.findUser(id);
	}
}