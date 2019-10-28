package com.rushit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushit.model.dao.ReviewDAO;
import com.rushit.model.vo.Fav;
import com.rushit.model.vo.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewDAO reviewDao;

	@Autowired
	public void setReviewDao(ReviewDAO reviewDao) {
		this.reviewDao = reviewDao;
	}

	@Override
	public Review selectReview(Fav love) {
		return reviewDao.selectReview(love);
	}
	
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

	@Override
	public List<Review> selectReviewListByToilet(String toilet_id) {
		return reviewDao.selectReviewListbyToilet(toilet_id);
	}

	@Override
	public List<Review> selectReviewListByUser(String user_id) {
		return reviewDao.selectReviewListbyUser(user_id);
	}

		
}