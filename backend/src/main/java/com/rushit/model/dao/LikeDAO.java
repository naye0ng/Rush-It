package com.rushit.model.dao;

import java.util.List;

import com.rushit.model.vo.Likes;

public interface LikeDAO {
	List<Likes> searchAll();
	void insertLike(Likes likes);
	void deleteLike(Likes likes);
}
