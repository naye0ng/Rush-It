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
	public Boolean addUser(User newUserInfo) {
		if(userDao.insertUser(newUserInfo)) {
			return true;
		}
		return false;
	}

	@Override
	public User loginUser(User loginUserInfo) {
		return userDao.loginUser(loginUserInfo);
	}

	@Override
	public User updateUser(User modifyUserInfo) {
		userDao.updateUser(modifyUserInfo);
		return userDao.findUser(modifyUserInfo.getId());
	}

	@Override
	public User findUser(String id) {
		return userDao.findUser(id);
	}

	@Override
	public Boolean deleteUser(User deleteUserInfo) {
		if(userDao.deleteUser(deleteUserInfo)) {
			return true;
		}
		return false;
	}
}