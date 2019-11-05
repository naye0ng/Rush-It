package com.rushit.model.service;

import java.util.HashMap;
import java.util.List;

import com.rushit.model.vo.Fav;
import com.rushit.model.vo.Review;

public interface ReviewService {
	
	Review selectReview(Fav love);

	List<Review> selectReviewListByToilet(String toilet_id);

	List<Review> selectReviewListByUser(String user_id);
	
	boolean addReview(Review review);

	boolean deleteReview(HashMap<String, String> map);
	
	boolean updateReview(Review review);

	HashMap<String, Object> selectRank(String id);

	List<HashMap<String, Object>> selectTopTen();

}