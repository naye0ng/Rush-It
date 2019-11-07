package com.rushit.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rushit.model.vo.tRank;

@Component
public class RankDAOImpl implements RankDAO {
	
	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	@Override
	public List<tRank> selectToiletRankList() {
		return session.selectList("rank.selectToiletRankList");
//		HashMap<String, String> Container = new HashMap<>();
//		
//		if(rList == null) {
//			Container.put("code", "400");
//		} else {
//			Container.put("code", "200");
//			Container.put("id", )
//		}
		
	}

}
