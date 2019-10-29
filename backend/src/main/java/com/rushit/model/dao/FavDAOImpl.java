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
	public void insertFav(Fav newFavToilet) {
		session.insert("fav.insertFav", newFavToilet);
	}

	@Override
	public void deleteFav(Fav delFavToilet) {
		session.delete("fav.deleteFav", delFavToilet);
	}
	
	@Override
	public boolean selectIsFav(HashMap<String, String> map) {
		return session.selectOne("fav.selectIsFav", map);
	}
	
	@Override
	public Fav selectFav(HashMap<String, String> map) {
		return session.selectOne("fav.selectFav", map);
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
