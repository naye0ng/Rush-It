package com.rushit.model.service;

import com.rushit.model.vo.Like;

public interface LikeService {
	boolean addLike(Like like);
	
	boolean deleteLike(Like like);
}
