package com.rushit.model.service;

import java.util.List;

import com.rushit.model.vo.Fav;
import com.rushit.model.vo.Review;

public interface ReviewService {
	
	Review selectReview(Fav love);

	List<Review> selectReviewList(String toilet_id);

	boolean addReview(Review review);

	boolean deleteReview(int number);

	boolean deleteReviewList(int number);

}