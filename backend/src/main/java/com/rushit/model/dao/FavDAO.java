package com.rushit.model.dao;

import java.util.HashMap;

import com.rushit.model.vo.Fav;

public interface FavDAO {
	Boolean insertFav(Fav fav);
	Boolean deleteFav(Fav fav);
	Boolean selectIsFav(HashMap<String, String> map);
	Fav selectFav(HashMap<String, String> map);
	int favToilet(String toilet_id);
	int notFavToilet(String toilet_id);
}
