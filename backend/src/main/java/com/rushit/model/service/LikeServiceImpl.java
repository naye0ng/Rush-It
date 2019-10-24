package com.rushit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushit.model.dao.LikeDAO;
import com.rushit.model.vo.Likes;

@Service
public class LikeServiceImpl implements LikeService {

	Likes test = new Likes("toilet", "user", true);
	
	private LikeDAO likeDao;
	
	@Autowired
	public void setLikeDao(LikeDAO likeDao) {
		this.likeDao = likeDao;
	}
	
	@Override
	public boolean addLike(Likes likes) {
		System.out.println("likeServiceinsert");
		likeDao.insertLike(test);
		return true;
	}

	@Override
	public boolean deleteLike(Likes likes) {
		likeDao.deleteLike(test);
		return true;
	}

	@Override
	public List<Likes> searchAll() {
		System.out.println("likeServiceSelect");

		return likeDao.searchAll();
	}

}
