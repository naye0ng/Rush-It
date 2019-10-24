package com.rushit.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rushit.model.vo.Like;

@Component
public class LikeDAOImpl implements LikeDAO {

	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public void insertLike(Like like) {
		session.insert("like.insertLike", like);
	}

	@Override
	public void deleteLike(Like like) {
		session.delete("like.deleteLike", like);
	}
}
