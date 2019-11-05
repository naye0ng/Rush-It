package com.rushit.model.dao;

import java.util.List;

import com.rushit.model.vo.tRank;

public interface RankDAO {
	List<tRank> selectToiletRankList();
}
