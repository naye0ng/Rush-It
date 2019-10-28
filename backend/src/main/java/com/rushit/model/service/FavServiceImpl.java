package com.rushit.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushit.model.dao.FavDAO;
import com.rushit.model.vo.Fav;

@Service
public class FavServiceImpl implements FavService {

	Fav test = new Fav("toilet", "user", true);
	
	private FavDAO favDao;
	
	@Autowired
	public void setFavDao(FavDAO favDao) {
		this.favDao = favDao;
	}
	
	@Override
	public boolean addFav(Fav newFavToilet) {
		favDao.insertFav(newFavToilet);
		return true;
	}

	@Override
	public boolean removeFav(Fav delFavToilet) {
		favDao.deleteFav(delFavToilet);
		return true;
	}


	@Override
	public int toiletFavCnt(String toilet_id) {
		return favDao.favToilet(toilet_id);
	}

	@Override
	public int toiletNotFavCnt(String toilet_id) {
		return favDao.notFavToilet(toilet_id);
	}

	@Override
	public boolean selectIsFav(HashMap<String, String> map) {
		return favDao.selectIsFav(map);
	}

	@Override
	public Fav selectFav(HashMap<String, String> map) {
		return favDao.selectFav(map);
	}


}
