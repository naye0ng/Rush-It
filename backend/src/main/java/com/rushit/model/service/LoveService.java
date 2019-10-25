package com.rushit.model.service;

import com.rushit.model.vo.Love;


public interface LoveService {
	boolean addLove(Love love);
	boolean removeLove(Love love);
	boolean checkLove(Love love);
	int toiletLoveCnt(String toilet_id);
	int toiletDisloveCnt(String toilet_id);
}
