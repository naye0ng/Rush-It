package com.rushit.model.dao;

import com.rushit.model.vo.Toilet;

public interface ToiletDAO {

	void insertToilet(Toilet toilet);

	void deleteToilet(String id);

	Toilet selectToilet(String id);

}