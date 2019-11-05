package com.rushit.model.service;

import java.util.HashMap;
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

	@Override
	public boolean addReview(Review review) {
		reviewDao.insertReview(review);
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

	@Override
	public boolean updateReview(Review review) {
		return reviewDao.updateReview(review);
	}
	@Override
	public boolean deleteReview(HashMap<String, String> map) {
		return reviewDao.deleteReview(map);
	}

	@Override
	public List<HashMap<String, Object>> selectTopTen(){
		return reviewDao.selectTopTen();
	}
	
	@Override
	public HashMap<String, Object> selectRank(String id){
		return reviewDao.selectRank(id);
	}

		
}