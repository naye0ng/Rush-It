package com.rushit.model.dao;

import java.util.HashMap;
import java.util.List;

import com.rushit.model.vo.Toilet;

public interface ToiletDAO {

	void insertToilet(Toilet toilet);

	void deleteToilet(String id);

	Toilet selectToilet(String id);
	
	List<Toilet> selectToiletList(HashMap<String, Object> map);

}