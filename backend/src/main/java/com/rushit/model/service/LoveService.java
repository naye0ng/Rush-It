package com.rushit.model.service;

import java.util.HashMap;

import com.rushit.model.vo.Love;


public interface LoveService {
	boolean addLove(Love love);
	boolean removeLove(Love love);
	boolean checkLove(HashMap<String, String> map);
	int toiletLoveCnt(String toilet_id);
	int toiletDisloveCnt(String toilet_id);
}
