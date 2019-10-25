package com.rushit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushit.model.dao.ReviewDAO;
import com.rushit.model.vo.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewDAO reviewDao;

	@Autowired
	public void setReviewDao(ReviewDAO reviewDao) {
		this.reviewDao = reviewDao;
	}

	@Override
	public Review selectReview(int number) {
		return reviewDao.selectReview(number);
	}
	
	/* (non-Javadoc)
	 * @see com.team3.model.service.ReviewService#selectReviewList(int)
	 */
	@Override
	public List<Review>selectReviewList(int number){
		return reviewDao.selectReviewList(number);
	}
	
	/* (non-Javadoc)
	 * @see com.team3.model.service.ReviewService#setReviewDao(com.team3.model.dao.ReviewDAO)
	 */
	
	/* (non-Javadoc)
	 * @see com.team3.model.service.ReviewService#addReview(com.team3.model.vo.Review)
	 */
	@Override
	public boolean addReview(Review review) {
		reviewDao.insertReview(review);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.team3.model.service.ReviewService#deleteReview(int)
	 */
	@Override
	public boolean deleteReview(int number) {
		reviewDao.deleteAnswer(number);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.team3.model.service.ReviewService#deleteReviewList(int)
	 */
	@Override
	public boolean deleteReviewList(int number) {
		reviewDao.deleteAnswerList(number);
		return true;
	}

		
}