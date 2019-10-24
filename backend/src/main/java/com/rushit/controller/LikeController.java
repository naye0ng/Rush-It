package com.rushit.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rushit.model.service.LikeService;
import com.rushit.model.vo.Like;

@Controller
public class LikeController {
	private LikeService likeService;
	
	@Autowired
	public void setLikeService(LikeService likeService) {
		this.likeService = likeService;
	}
	
	@RequestMapping("/likeTest")
	public void root_test(HttpServletResponse response) throws Exception{
		response.getWriter().print("HELLO");
	}
	
	@PostMapping("/like")
	public ResponseEntity<Boolean> registerQna(@RequestBody Like like){
		return likeService.addLike(like) ? new ResponseEntity<Boolean>(true, HttpStatus.OK) : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
	}
	
	@DeleteMapping("/like")
	public void deleteLike(@RequestBody Like like) {
		likeService.deleteLike(like);
	}
}
