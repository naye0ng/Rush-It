package com.rushit.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rushit.model.vo.Fav;
import com.rushit.model.vo.Review;

@Component
public class ReviewDAOImpl implements ReviewDAO {
	private SqlSession session;

	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	/* (non-Javadoc)
	 * @see com.team3.model.dao.ReviewDao#insertReview(com.team3.model.vo.Review)
	 */
	@Override
	public boolean insertReview(Review review) {
		if(session.insert("review.insertReview",review)!=1) {
			return false;
		}
		return true;
	}

	@Override
	public Review selectReview(Fav love) {
		return session.selectOne("review.selectReview", love);
	}

	@Override
	public List<Review> selectReviewListbyUser(String user_id) {
		return session.selectList("review.selectReviewByUser", user_id);
	}

	@Override
	public List<Review> selectReviewListbyToilet(String toilet_id) {
		return session.selectList("review.selectReviewByToilet", toilet_id);
	}

	@Override
	public boolean updateReview(Review review) {
		if(session.update("review.updateReview", review)!=1) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteReview(HashMap<String, String> map) {
		if(session.delete("review.deleteReive", map)!=1) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<HashMap<String, Object>> selectTopTen(){
		return session.selectList("review.selectTopTen");
	}
	
	@Override
	public HashMap<String, Object> selectRank(String id){
		return session.selectOne("review.selectReviewRank", id);
	}
}


