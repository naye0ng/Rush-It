package com.rushit.model.service;

import com.rushit.model.vo.Fav;


public interface FavService {
	boolean addFav(Fav fav);
	boolean removeFav(Fav fav);
	boolean checkFav(Fav fav);
	int toiletFavCnt(String toilet_id);
	int toiletNotFavCnt(String toilet_id);
}
