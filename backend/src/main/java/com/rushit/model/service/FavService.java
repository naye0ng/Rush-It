package com.rushit.model.service;

import java.util.HashMap;

import com.rushit.model.vo.Fav;


public interface FavService {
	Boolean addFav(Fav favInfo);
	Boolean modifyFav(Fav favInfo);
	Boolean removeFav(Fav favInfo);
	Boolean selectIsFav(HashMap<String, String> favInfoMap);
	Fav selectFav(HashMap<String, String> favInfoMAp);
	int toiletFavCnt(String toilet_id);
	int toiletNotFavCnt(String toilet_id);
}
