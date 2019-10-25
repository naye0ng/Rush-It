package com.rushit.model.service;

import java.util.List;

import com.rushit.model.vo.Review;

public interface ReviewService {
	
	Review selectReview(int number);

	List<Review> selectReviewList(int number);

	boolean addReview(Review review);

	boolean deleteReview(int number);

	boolean deleteReviewList(int number);

}