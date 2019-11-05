package com.rushit.model.service;

import java.util.HashMap;

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
	public Boolean addFav(Fav favInfo) {
		if(favDao.insertFav(favInfo)) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean modifyFav(Fav favInfo) {
		if(favDao.updateFav(favInfo)) {
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean removeFav(Fav favInfo) {
		if(favDao.deleteFav(favInfo)) {
			return true;
		}
		return false;
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
	public Boolean selectIsFav(HashMap<String, String> favInfoMap) {
		return favDao.selectIsFav(favInfoMap);
	}

	@Override
	public Fav selectFav(HashMap<String, String> favInfoMap) {
		return favDao.selectFav(favInfoMap);
	}
}
