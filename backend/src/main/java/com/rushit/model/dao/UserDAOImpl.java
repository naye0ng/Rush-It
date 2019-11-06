package com.rushit.model.dao;

import java.util.HashMap;
import java.util.List;

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
	public HashMap<String, String> loginUser(User loginUserInfo) {
		User user = session.selectOne("user.loginUser", loginUserInfo);
		HashMap<String, String> Container = new HashMap<>();
		Container.put("code", "200");
		Container.put("id", user.getId());
		Container.put("nick", user.getNick());
		
		return Container;
	}

	@Override
	public List<User> findAllUsers() {
		return session.selectList("user.findAllUsers");
	}	

	@Override
	public User findUserById(String id) {
		return session.selectOne("user.findUser", id);
	}

	@Override
	public Boolean insertUser(User user) {
		if(session.insert("user.insertUser", user) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateUser(User modifyUserInfo) {
		if(session.update("user.updateUser", modifyUserInfo) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteUser(User deleteUserInfo) {
		if(session.delete("user.deleteUser", deleteUserInfo) == 1) {
			return true;
		}
		return false;
	}

}
