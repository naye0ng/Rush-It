package com.rushit.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.rushit.model.vo.Review;

@CrossOrigin(origins= {"*"})
@RestController
public class ReviewController {

	private ReviewService rs;

	@Autowired
	public void setRs(ReviewService rs) {
		this.rs = rs;
	}
	
	@PostMapping("/test")
	public void test(@RequestParam String query) throws IOException {
		System.out.println(query);
	}
	
	@GetMapping("/test")
	public void test(HttpServletResponse response) throws IOException {
		response.getWriter().print("hello");
	}
	
	@PostMapping("/review")
	public HashMap<String, String> registerReview(@RequestParam Double score, @RequestParam String review, @RequestParam String user_id, @RequestParam String toilet_id){
		Date currentTime = new Date();
		HashMap<String, String> hash= new HashMap<>();
		Review r = new Review(toilet_id, user_id, review, score, currentTime);
		if(rs.addReview(r)) {
			hash.put("code", "200");
		}
		else {
			hash.put("code", "300");
		}
		return hash;
	}
	
	@DeleteMapping("/review")
	public HashMap<String, String> deleteReview(@RequestParam String user_id, @RequestParam String toilet_id){
		HashMap<String, String> map= new HashMap<>();
		map.put("user_id", user_id);
		map.put("toilet_id", toilet_id);
		HashMap<String, String> ret= new HashMap<>();
		if(rs.deleteReview(map)) {
			ret.put("code", "200");
		}
		else ret.put("code", "301");
		return ret;
	}
	
	@PutMapping("/review")
	public ResponseEntity<Boolean> updateReview(@RequestParam Double score, @RequestParam String review, @RequestParam String user_id, @RequestParam String toilet_id){
		Date currentTime = new Date();
		Review r = new Review(toilet_id, user_id, review, score, currentTime);
		return rs.updateReview(r) ? new ResponseEntity<Boolean>(true, HttpStatus.OK) : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public ResponseEntity<List<Review>> getReivewbyToilet(@RequestParam Map<String, String> params) {
		System.out.println(params.toString());
		List<Review> list=null;
		if(params.keySet().contains("toilet_id")) {
			list= rs.selectReviewListByToilet(params.get("toilet_id"));
			if(list.size()==0) return new ResponseEntity<List<Review>>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<Review>>(list, HttpStatus.OK); 
		}
		else if(params.keySet().contains("user_id")) {
			list= rs.selectReviewListByToilet(params.get("user_id"));
			if(list.size()==0) return new ResponseEntity<List<Review>>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<Review>>(list, HttpStatus.OK); 
		}
		return null;
	}
}
