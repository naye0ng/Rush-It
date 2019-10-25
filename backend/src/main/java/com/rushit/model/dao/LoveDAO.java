package com.rushit.model.dao;

import com.rushit.model.vo.Love;

public interface LoveDAO {
	void insertLove(Love love);
	void deleteLove(Love love);
	boolean selectLove(Love love);
	int loveToilet(String toilet_id);
	int disloveToilet(String toilet_id);
}
