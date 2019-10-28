package com.rushit.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rushit.model.vo.Love;
import com.rushit.model.vo.Review;

@Component
public class ReviewDAOImpl implements ReviewDAO {
	private SqlSession session;

	/* (non-Javadoc)
	 * @see com.team3.model.dao.ReviewDao#setSession(org.apache.ibatis.session.SqlSession)
	 */
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	/* (non-Javadoc)
	 * @see com.team3.model.dao.ReviewDao#insertReview(com.team3.model.vo.Review)
	 */
	@Override
	public void insertReview(Review review) {
		session.insert("review.insertReview",review);
	}
	
	/* (non-Javadoc)
	 * @see com.team3.model.dao.ReviewDao#selectReviewList(int)
	 */
	@Override
	public List<Review> selectReviewList(int number){
		return session.selectList("review.selectReviewList", number);
	}
	
	/* (non-Javadoc)
	 * @see com.team3.model.dao.ReviewDao#deleteAnswerList(int)
	 */
	@Override
	public void deleteAnswerList(int number) {
		session.delete("review.deleteAnswerList", number);
	}
	
	/* (non-Javadoc)
	 * @see com.team3.model.dao.ReviewDao#deleteAnswer(int)
	 */
	@Override
	public void deleteAnswer(int number) {
		session.delete("review.deleteAanswer", number);
	}

	@Override
	public Review selectReview(Love love) {
		return session.selectOne("review.selectReview", love);
	}
	
	@Override
	public List<Review> selectReviewList(String id){
		return session.selectList("review.selectReviewList", id);
	}
}


