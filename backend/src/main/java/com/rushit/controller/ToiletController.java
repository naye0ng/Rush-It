package com.rushit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.LoveService;
import com.rushit.model.service.ReviewService;
import com.rushit.model.service.ToiletService;
import com.rushit.model.service.UserService;
import com.rushit.model.vo.Love;
import com.rushit.model.vo.Review;
import com.rushit.model.vo.Toilet;
import com.rushit.model.vo.User;

@RequestMapping	
@RestController
public class ToiletController {
	private ToiletService ts;
	private ReviewService rs;
	private UserService us;
	private LoveService ls;

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

	@Autowired
	public void setLs(LoveService ls) {
		this.ls = ls;
	}

	@RequestMapping("/toilet/{toilet_id}")
	public void toiletDetail(@PathVariable String toilet_id, @RequestParam String user_id) {
		Toilet t=ts.selectToilet(toilet_id);
		User u=us.findUser(user_id);
		String getId=t.getId();
		Love temp=new Love(toilet_id, user_id, true);
		//해당 유저가 좋아요 했는지 여부
		boolean userLove=ls.checkLove(temp);
		//전체 좋아요 갯수
		int likeCount=ls.toiletLoveCnt(toilet_id);
		//전체 싫어요 갯수
		int dislikeCount=ls.toiletDisloveCnt(toilet_id);
		//리뷰 리스트
		ArrayList<Review> reviewList= (ArrayList<Review>) rs.selectReviewList(toilet_id);
		
	}
	
	
	
}
