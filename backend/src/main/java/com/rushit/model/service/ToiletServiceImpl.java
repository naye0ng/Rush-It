package com.rushit.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushit.model.dao.ToiletDAO;
import com.rushit.model.vo.Toilet;

@Service
public class ToiletServiceImpl implements ToiletService {
	
	private ToiletDAO toiletDao;

	@Autowired
	public void setToiletDao(ToiletDAO toiletDao) {
		this.toiletDao = toiletDao;
	}
	
	/* (non-Javadoc)
	 * @see com.rushit.model.service.ToiletService#selectToilet(java.lang.String)
	 */
	@Override 
	public Toilet selectToilet(String id) {
		return toiletDao.selectToilet(id);
	}
	
	/* (non-Javadoc)
	 * @see com.rushit.model.service.ToiletService#addToilet(com.rushit.model.vo.Toilet)
	 */
	@Override
	public boolean addToilet(Toilet toilet) {
		toiletDao.insertToilet(toilet);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.rushit.model.service.ToiletService#deleteToilet(java.lang.String)
	 */
	@Override
	public boolean deleteToilet(String id) {
		toiletDao.deleteToilet(id);
		return true;
	}

	@Override
	public List<Toilet> selectToiletList(HashMap<String, Object> map) {
		return toiletDao.selectToiletList(map);
	}
	
}
