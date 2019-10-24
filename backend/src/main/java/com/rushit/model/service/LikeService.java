package com.rushit.model.service;

import java.util.List;

import com.rushit.model.vo.Likes;


public interface LikeService {
	List<Likes> searchAll();
	boolean addLike(Likes likes);
	boolean deleteLike(Likes likes);
}
