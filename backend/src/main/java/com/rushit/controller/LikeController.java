package com.rushit.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.LikeService;
import com.rushit.model.vo.Likes;
@RequestMapping
@RestController

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
	
	@GetMapping("/likeGet")
	public void selectLike() {
		System.out.println("SELECT");
		System.out.println(likeService.searchAll());
	}
	
	
	@GetMapping("/likeAdd")
	public ResponseEntity<Boolean> registerQna(){
		Likes likes = new Likes("test", "test", true);
		System.out.println("INSERT");
		return likeService.addLike(likes) ? new ResponseEntity<Boolean>(true, HttpStatus.OK) : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
		
	}
	
	@RequestMapping("/likeDelete")
	public void deleteLike(@RequestBody Likes like) {
		System.out.println("DELETE");
		likeService.deleteLike(like);
	}
}
