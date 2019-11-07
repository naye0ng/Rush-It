package com.rushit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushit.model.dao.RankDAO;
import com.rushit.model.vo.tRank;

@Service
public class RankServiceImpl implements RankService {

	private RankDAO rankDao;
	
	@Autowired
	public void setRankDao(RankDAO rankDao) {
		this.rankDao = rankDao;
	}
	
	@Override
	public List<tRank> getToiletRank() {
		return rankDao.selectToiletRankList();	
	}
}
