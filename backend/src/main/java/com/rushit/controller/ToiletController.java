package com.rushit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.ReviewService;
import com.rushit.model.service.ToiletService;
import com.rushit.model.vo.Toilet;
import com.rushit.model.vo.User;

@RequestMapping
@RestController
public class ToiletController {
	private ToiletService ts;
	private ReviewService rs;

	@Autowired
	public void setTs(ToiletService ts) {
		this.ts = ts;
	}
	
	@Autowired
	public void setRs(ReviewService rs) {
		this.rs = rs;
	}

	@RequestMapping("/toilet/{toilet_id}")
	public void toiletDetail(@PathVariable String toilet_id, @RequestParam User user_id) {
		Toilet t=ts.selectToilet(toilet_id);
		
		
	}
	
	
	
}
