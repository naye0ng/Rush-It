package com.rushit.model.service;

import java.util.HashMap;
import java.util.List;

import com.rushit.model.vo.Toilet;

public interface ToiletService {

	Toilet selectToilet(String id);

	boolean addToilet(Toilet toilet);

	boolean deleteToilet(String id);
	
	List<Toilet> selectToiletList(HashMap<String, Object> map);

}