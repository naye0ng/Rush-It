package com.rushit.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rushit.model.vo.User;

@Component
public class UserDAOImpl implements UserDAO {

	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public Boolean insertUser(User user) {
		if(session.insert("user.insertUser", user) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public User loginUser(User loginUserInfo) {
		return session.selectOne("user.loginUser", loginUserInfo);
	}

	@Override
	public User findUser(String id) {
		return session.selectOne("user.findUser", id);
	}

	@Override
	public void updateUser(User modifyUserInfo) {
		session.update("user.updateUser", modifyUserInfo);
	}

	@Override
	public Boolean deleteUser(User deleteUserInfo) {
		if(session.delete("user.deleteUser", deleteUserInfo) == 1) {
			return true;
		}
		return false;
	}	
}
