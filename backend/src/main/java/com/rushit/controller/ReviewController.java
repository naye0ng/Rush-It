package com.rushit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.ReviewService;
import com.rushit.model.service.ToiletService;
import com.rushit.model.service.UserService;
import com.rushit.model.vo.Review;

@CrossOrigin(origins= {"*"})
@RestController
public class ReviewController {

	private ReviewService rs;
	private UserService us;
	
	@Autowired
	private ToiletService ts;

	@Autowired
	public void setRs(ReviewService rs) {
		this.rs = rs;
	}
	
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}
	
	

	@PostMapping("/test")
	public HashMap<String, String> test(@RequestBody String query) throws IOException {
		System.out.println(query);

		HashMap<String, String> hash= us.checkUser("honey");
		return hash;
	}
	
	@GetMapping("/test")
	public void test(HttpServletResponse response) throws IOException {
		response.getWriter().print("hello");
	}
	
	@PostMapping("/review")
	public ResponseEntity<HashMap<String, String>> registerReview(@RequestParam Double score, @RequestParam String review, @RequestParam String user_id, @RequestParam String toilet_id){
		Date currentTime = new Date();
		HashMap<String, String> hash= new HashMap<>();
		Review r = new Review(toilet_id, user_id, review, score, currentTime);
		if(rs.addReview(r)) {
			hash.put("code", "200");
			return new ResponseEntity<HashMap<String,String>>(hash, HttpStatus.OK);
		}
		else {
			hash.put("code", "300");
			return new ResponseEntity<HashMap<String,String>>(hash, HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/review")
	public ResponseEntity<HashMap<String, String>> deleteReview(@RequestParam String user_id, @RequestParam String toilet_id){
		HashMap<String, String> map= new HashMap<>();
		map.put("user_id", user_id);
		map.put("toilet_id", toilet_id);
		HashMap<String, String> ret= new HashMap<>();
		if(rs.deleteReview(map)) {
			ret.put("code", "200");
			return new ResponseEntity<HashMap<String,String>>(map, HttpStatus.OK);
		}
		else {
			ret.put("code", "301");
			return new ResponseEntity<HashMap<String,String>>(map, HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/review")
	public ResponseEntity<HashMap<String, String>> updateReview(@RequestParam Double score, @RequestParam String review, @RequestParam String user_id, @RequestParam String toilet_id){
		Date currentTime = new Date();
		HashMap<String, String> ret= new HashMap<>();
		Review r = new Review(toilet_id, user_id, review, score, currentTime);
		if(rs.updateReview(r)) {
			ret.put("code", "200");
			return new ResponseEntity<HashMap<String,String>>(ret, HttpStatus.OK);
		}
		else {
			ret.put("code", "301");
			return new ResponseEntity<HashMap<String,String>>(ret, HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public HashMap<String, Object> getReivewbyToilet(@RequestParam HashMap<String, String> params) {
		HashMap<String, Object> responseData= new HashMap<>();
		List<HashMap<String, Object>> responseList = new ArrayList<>();
		
		List<Review> list = null;
		if(params.keySet().contains("toilet_id")) {
			list= rs.selectReviewListByToilet(params.get("toilet_id"));
		}
		else if(params.keySet().contains("user_id")) {
			list= rs.selectReviewListByUser(params.get("user_id"));
		}
		
		if(list.size()==0) responseData.put("code", "301");
		
		else {
			responseData.put("code", "301");
			for(Review review : list) {
				HashMap<String, Object> reviewDetail = new HashMap<>();
				reviewDetail.put("toilet_id", review.getToilet_id());
				reviewDetail.put("toilet_name", ts.selectToilet(review.getToilet_id()).getName());
				reviewDetail.put("score", review.getRating());
				reviewDetail.put("review", review.getReview());
				reviewDetail.put("time", review.getTimestamp());
				
				responseList.add(reviewDetail);
			}
			responseData.put("reviews", responseList);
		}
		
		System.out.println(responseData.toString());
		
		return responseData;
	}

}
