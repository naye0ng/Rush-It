package com.rushit.model.dao;

import java.util.HashMap;

import com.rushit.model.vo.Fav;

public interface FavDAO {
	Boolean insertFav(Fav favInfo);
	Boolean updateFav(Fav favInfo);
	Boolean deleteFav(Fav favInfo);
	Boolean selectIsFav(HashMap<String, String> favInfoMap);
	Fav selectFav(HashMap<String, String> favInfoMap);
	int favToilet(String toilet_id);
	int notFavToilet(String toilet_id);
}
