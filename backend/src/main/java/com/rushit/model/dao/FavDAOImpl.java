package com.rushit.model.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rushit.model.vo.Fav;

@Component
public class FavDAOImpl implements FavDAO {

	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public Boolean insertFav(Fav favInfo) {
		if(session.insert("fav.insertFav", favInfo) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateFav(Fav favInfo) {
		if(session.update("fav.updateFav", favInfo) == 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean deleteFav(Fav favInfo) {
		if(session.delete("fav.deleteFav", favInfo) == 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean selectIsFav(HashMap<String, String> favInfoMap) {
		return session.selectOne("fav.selectIsFav", favInfoMap);
	}
	
	@Override
	public Fav selectFav(HashMap<String, String> favInfoMap) {
		return session.selectOne("fav.selectFav", favInfoMap);
	}

	@Override
	public int favToilet(String toilet_id) {
		return session.selectOne("fav.amountOfFav", toilet_id);
	}

	@Override
	public int notFavToilet(String toilet_id) {
		return session.selectOne("fav.amountOfNotFav", toilet_id);
	}


}
