package com.rushit.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rushit.model.vo.Likes;

@Component
public class LikeDAOImpl implements LikeDAO {

	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public void insertLike(Likes likes) {
		System.out.println("likeDAOinsert");
		session.insert("likes.insertLike", likes);
	}

	@Override
	public void deleteLike(Likes likes) {
		session.delete("likes.deleteLike", likes);
	}

	@Override
	public List<Likes> searchAll() {
		System.out.println("likeDAOSelect");

		return session.selectList("likes.selectLikeList");
	}
}
