package com.rushit.model.service;

import java.util.HashMap;

import com.rushit.model.vo.Fav;


public interface FavService {
	Boolean addFav(Fav fav);
	Boolean removeFav(Fav fav);
	Boolean selectIsFav(HashMap<String, String> map);
	Fav selectFav(HashMap<String, String> map);
	int toiletFavCnt(String toilet_id);
	int toiletNotFavCnt(String toilet_id);
}
