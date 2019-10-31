package com.rushit.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.ReviewService;
import com.rushit.model.vo.Review;

@CrossOrigin(origins= {"*"})
@RequestMapping("/review")
@RestController
public class ReviewController {

	private ReviewService rs;

	@Autowired
	public void setRs(ReviewService rs) {
		this.rs = rs;
	}
	
	@GetMapping("/test")
	public void test(HttpServletResponse response) throws IOException {
		response.getWriter().print("hello");
	}
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> registerReview(String id){
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		System.out.println( " Timestamp : " + ts);
		
		Review review2= new Review("123123", "siba", "넘넘 좋아요!", 3.5, ts);
		return rs.addReview(review2) ? new ResponseEntity<Boolean>(true, HttpStatus.OK) : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
	}
	
	@RequestMapping("/select/{toilet_id}")
	public ResponseEntity<List<Review>> getReivewbyToilet(@PathVariable String toilet_id) {
		List<Review> list= rs.selectReviewListByToilet(toilet_id);
		if(list.size()==0) {
			return new ResponseEntity<List<Review>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK); 
	}
	
	@RequestMapping("/select/{user_id}")
	public ResponseEntity<List<Review>> getReivewbyUser(@PathVariable String user_id) {
		List<Review> list= rs.selectReviewListByUser(user_id);
		if(list.size()==0) {
			return new ResponseEntity<List<Review>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK); 
	}
}
