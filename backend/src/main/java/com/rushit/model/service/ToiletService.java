package com.rushit.model.service;

import com.rushit.model.vo.Toilet;

public interface ToiletService {

	Toilet selectToilet(String id);

	boolean addToilet(Toilet toilet);

	boolean deleteToilet(String id);

}