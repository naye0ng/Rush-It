package com.rushit.model.service;

import java.util.HashMap;
import java.util.List;

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
	public HashMap<String, String> loginUser(User loginUserInfo) {
		return userDao.loginUser(loginUserInfo);
	}

	@Override
	public Boolean updateUser(User modifyUserInfo) {
		if(userDao.updateUser(modifyUserInfo)) {
			return true;
		}
		return false;
	}

	@Override
	public User findUser(String id) {
		return userDao.findUserById(id);
	}

	@Override
	public Boolean deleteUser(User deleteUserInfo) {
		if(userDao.deleteUser(deleteUserInfo)) {
			return true;
		}
		return false;
	}


	@Override
	public HashMap<String, String> checkNull(String id, String pw) {
		HashMap<String, String> errorMsg = new HashMap<>();
		if(id.equals("") || id.trim().length() == 0) errorMsg.put("code", "");
		if(pw.equals("") || pw.trim().length() == 0) errorMsg.put("code", "");
		return errorMsg;
	}


	@Override
	public HashMap<String, String> checkUser(String id) {
		List<User> users = userDao.findAllUsers();
		HashMap<String, String> errorMsg = new HashMap<>();
		errorMsg.put("code", "");
		for(User u : users) {
			if(u.getId().equalsIgnoreCase(id)) {
				errorMsg.put("code", "300");
				break;
			}
		}
		return errorMsg;
	}
}