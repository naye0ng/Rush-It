package com.rushit.model.service;

import java.util.HashMap;

import com.rushit.model.vo.Fav;


public interface FavService {
	boolean addFav(Fav fav);
	boolean removeFav(Fav fav);
	boolean selectIsFav(HashMap<String, String> map);
	Fav selectFav(HashMap<String, String> map);
	int toiletFavCnt(String toilet_id);
	int toiletNotFavCnt(String toilet_id);
}
