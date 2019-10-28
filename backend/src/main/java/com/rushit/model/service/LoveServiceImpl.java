package com.rushit.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushit.model.dao.LoveDAO;
import com.rushit.model.vo.Love;

@Service
public class LoveServiceImpl implements LoveService {

	Love test = new Love("toilet", "user", true);
	
	private LoveDAO loveDao;
	
	@Autowired
	public void setLoveDao(LoveDAO loveDao) {
		this.loveDao = loveDao;
	}
	
	@Override
	public boolean addLove(Love love) {
		loveDao.insertLove(test);
		return true;
	}

	@Override
	public boolean removeLove(Love love) {
		loveDao.deleteLove(test);
		return true;
	}

	@Override
	public boolean checkLove(HashMap<String, String> map) {
		return loveDao.selectLove(map);
	}

	@Override
	public int toiletLoveCnt(String toilet_id) {
		return loveDao.loveToilet(toilet_id);
	}

	@Override
	public int toiletDisloveCnt(String toilet_id) {
		return loveDao.disloveToilet(toilet_id);
	}


}
