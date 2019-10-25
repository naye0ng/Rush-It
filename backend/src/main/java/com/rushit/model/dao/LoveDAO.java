package com.rushit.model.dao;

import java.util.List;

import com.rushit.model.vo.Love;

public interface LoveDAO {
	void insertLove(Love love);
	void deleteLove(Love love);
	List<Love> searchAllLove();
}
