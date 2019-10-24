package com.rushit.model.dao;

import com.rushit.model.vo.Like;

public interface LikeDAO {
	void insertLike(Like like);
	
	void deleteLike(Like like);
}
