package com.rushit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<Boolean> registerReview(){
		System.out.println("hrer");
		Review review2= new Review(3, "하위", "ㅇㄷ", "으앜아크", 4, "2019-09-03");
		return rs.addReview(review2) ? new ResponseEntity<Boolean>(true, HttpStatus.OK) : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
	}
	
	@RequestMapping("/select/{number}")
	public ResponseEntity<Review> getReivew(@PathVariable int number) {
		Review rev= rs.selectReview(number);
		System.out.println(rev+"thisishere");
		if(rev==null)
			return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Review>(rev, HttpStatus.OK);
		
	}
	
}
