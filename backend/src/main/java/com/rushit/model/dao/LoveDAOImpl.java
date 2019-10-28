package com.rushit.model.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rushit.model.vo.Love;

@Component
public class LoveDAOImpl implements LoveDAO {

	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public void insertLove(Love love) {
		session.insert("love.insertLove", love);
	}

	@Override
	public void deleteLove(Love love) {
		session.delete("love.deleteLove", love);
	}

	@Override
	public boolean selectLove(HashMap<String, String> map) {
		return session.selectOne("love.selectLove", map);
	}

	@Override
	public int loveToilet(String toilet_id) {
		return session.selectOne("love.amountOfLove", toilet_id);
	}

	@Override
	public int disloveToilet(String toilet_id) {
		return session.selectOne("love.amountOfDislove", toilet_id);
	}

}
