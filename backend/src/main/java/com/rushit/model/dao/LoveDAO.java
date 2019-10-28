package com.rushit.model.dao;

import java.util.HashMap;

import com.rushit.model.vo.Love;

public interface LoveDAO {
	void insertLove(Love love);
	void deleteLove(Love love);
	boolean selectLove(HashMap<String, String> map);
	int loveToilet(String toilet_id);
	int disloveToilet(String toilet_id);
}
