package com.rushit.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.FavService;
import com.rushit.model.service.ReviewService;
import com.rushit.model.service.ToiletService;
import com.rushit.model.service.UserService;
import com.rushit.model.vo.Review;
import com.rushit.model.vo.Toilet;

@RestController
@RequestMapping("/toilet")
public class ToiletController {
	private ToiletService ts;
	private ReviewService rs;
	private UserService us;
	private FavService fs;

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
	public void setLs(FavService fs) {
		this.fs = fs;
	}

	@GetMapping("/")
	public ResponseEntity<HashMap<String, Object>> findToilet(@RequestParam Double user_x, @RequestParam Double user_y, @RequestParam Double sw_x, @RequestParam Double nw_x, @RequestParam Double nw_y, @RequestBody String keyword) {
			
		
		HashMap<String, Object> ret= new HashMap<String,Object>();
		return new ResponseEntity<HashMap<String,Object>>(ret,HttpStatus.OK);
	}
	
	@GetMapping("/{toilet_id}")
	public ResponseEntity<HashMap<String, Object>> toiletDetail(@PathVariable String toilet_id, @RequestParam String user_id) {
		System.out.println(toilet_id+" "+user_id);
		//map 형태로 loveService의 인자값에 넘겨준다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("toilet_id", toilet_id);
		map.put("user_id", user_id);
		//해당 유저가 좋아요 했는지 여부
		int userLove=0;
		//review를  먼저 갔다와서 평가 했는지 안했는지 여부를 먼저 확인한다.
		if(fs.selectFav(map)==null) userLove=0; 
		else if(fs.selectIsFav(map))userLove=1;
		else if(!fs.selectIsFav(map))userLove=-1;
		//전체 좋아요 갯수
		int likeCount=fs.toiletFavCnt(toilet_id);
		//전체 싫어요 갯수
		int dislikeCount=fs.toiletNotFavCnt(toilet_id);
		//리뷰 리스트
		ArrayList<Review> reviewList= (ArrayList<Review>) rs.selectReviewListByToilet(toilet_id);
		double reviewTotal=0;
		for(int i=0; i<reviewList.size(); i++) {
			reviewTotal+=reviewList.get(i).getRating();
		}
		reviewTotal/=reviewList.size();
		reviewTotal=Math.round((reviewTotal*10))/10.0;
		//telephone, handicapped, state, time을 toilet_id로 조회
		Toilet t=ts.selectToilet(toilet_id);
		
		//hashmap을 사용하여 key,value로 값으로 front에 전달한다.
		HashMap<String, Object> ret= new HashMap<String,Object>();
		ret.put("toilet_id", toilet_id);
		ret.put("likeCount", likeCount);
		ret.put("dislikeCount", dislikeCount);
		ret.put("reviewList", reviewList);
		ret.put("reviewTotal", reviewTotal);
		ret.put("userLove", userLove);
<<<<<<< HEAD
		ret.put("telephone", t.getTelephone());
		ret.put("handicapped", t.isHandicapped());
		ret.put("state", t.getState());
		ret.put("time", t.getTime());
=======
		
>>>>>>> f9dd8084c65a75e80b3056956b5d407d6311a6ab
		return new ResponseEntity<HashMap<String,Object>>(ret,HttpStatus.OK);
	}
	
	
		
}
