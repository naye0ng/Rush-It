package com.rushit.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rushit.model.vo.Toilet;

@Component
public class ToiletDAOImpl implements ToiletDAO {
	
	private SqlSession session;

	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	/* (non-Javadoc)
	 * @see com.rushit.model.dao.ToiletDAO#insertToilet(com.rushit.model.vo.Toilet)
	 */
	@Override
	public void insertToilet(Toilet toilet) {
		session.insert("toilet.insertToilet", toilet);
	}
	
	/* (non-Javadoc)
	 * @see com.rushit.model.dao.ToiletDAO#deleteToilet(java.lang.String)
	 */
	@Override
	public void deleteToilet(String id) {
		session.delete("toilet.deleteToilet", id);
	}
	
	/* (non-Javadoc)
	 * @see com.rushit.model.dao.ToiletDAO#selectToilet(java.lang.String)
	 */
	@Override
	public Toilet selectToilet(String id) {
		return session.selectOne("toilet.selectToilet", id);
	}
	
}
