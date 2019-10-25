package com.rushit.model.service;

import java.util.List;

import com.rushit.model.vo.Love;


public interface LoveService {
	List<Love> getAllLove();
	boolean addLove(Love love);
	boolean removeLove(Love love);
}
