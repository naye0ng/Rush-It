package com.rushit.model.dao;

import com.rushit.model.vo.Fav;

public interface FavDAO {
	void insertFav(Fav fav);
	void deleteFav(Fav fav);
	boolean selectFav(Fav fav);
	int favToilet(String toilet_id);
	int notFavToilet(String toilet_id);
}
