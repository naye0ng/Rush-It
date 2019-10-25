package com.rushit.model.dao;

import java.util.List;

import com.rushit.model.vo.Review;

public interface ReviewDAO {

	void insertReview(Review review);

	List<Review> selectReviewList(int number);
	
	Review selectReview(int number);

	void deleteAnswerList(int number);

	void deleteAnswer(int number);

}