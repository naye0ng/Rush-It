package com.rushit.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<HashMap<String, Object>> toiletDetail(@PathVariable String toilet_id, @RequestParam String user_id) {
		//map 형태로 loveService의 인자값에 넘겨준다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(toilet_id, user_id);
		//해당 유저가 좋아요 했는지 여부
		int userLove=0;
		//review를  먼저 갔다와서 평가 했는지 안했는지 여부를 먼저 확인한다.
		if(ls.checkLove(map)==null)
		boolean checkLove=ls.checkLove(map);
		
		//전체 좋아요 갯수
		int likeCount=ls.toiletLoveCnt(toilet_id);
		//전체 싫어요 갯수
		int dislikeCount=ls.toiletDisloveCnt(toilet_id);
		//리뷰 리스트
		ArrayList<Review> reviewList= (ArrayList<Review>) rs.selectReviewList(toilet_id);
		double reviewTotal=0;
		for(int i=0; i<reviewList.size(); i++) {
			reviewTotal+=reviewList.get(i).getRating();
		}
		reviewTotal/=reviewList.size();
		reviewTotal=Math.round((reviewTotal*10)/10.0);
		//hashmap을 사용하여 key,value로 값으로 front에 전달한다.
		HashMap<String, Object> ret= new HashMap<String,Object>();
		ret.put("likeCount", likeCount);
		ret.put("dislikeCount", dislikeCount);
		ret.put("reviewList", reviewList);
		ret.put("reviewTotal", reviewTotal);
		ret.put("userLove", userLove);
		return null;
	}
	
	
	
}
