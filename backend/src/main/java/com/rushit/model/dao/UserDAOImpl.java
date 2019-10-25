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
	public void insertUser(User user) {
		session.insert("user.insertUser", user);
	}

	@Override
	public User loginUser(String id, String pw) {
		User user = new User();
		user.setId(id);
		user.setPw(pw);
		return session.selectOne("user.loginUser", user);
	}

	@Override
	public User findUser(String id) {
		User user = new User();
		user.setId(id);
		return session.selectOne("user.findUser", user);
	}

	@Override
	public void updateUser(String id, String nick) {
		User user = new User();
		user.setId(id);
		user.setNick(nick);
		session.update("user.updateUser", user);
	}	
}
