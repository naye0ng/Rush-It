package com.rushit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.ReviewService;
import com.rushit.model.service.ToiletService;
import com.rushit.model.service.UserService;
import com.rushit.model.vo.Toilet;
import com.rushit.model.vo.User;

@RequestMapping	
@RestController
public class ToiletController {
	private ToiletService ts;
	private ReviewService rs;
	private UserService us;

	@Autowired
	public void setTs(ToiletService ts) {
		this.ts = ts;
	}
	
	@Autowired
	public void setRs(ReviewService rs) {
		this.rs = rs;
	}
	
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}

	@RequestMapping("/toilet/{toilet_id}")
	public void toiletDetail(@PathVariable String toilet_id, @RequestParam User user_id) {
		Toilet t=ts.selectToilet(toilet_id);
		
		
	}
	
	
	
}
