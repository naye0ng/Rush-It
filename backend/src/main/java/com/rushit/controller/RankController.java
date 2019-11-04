package com.rushit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.RankService;

@CrossOrigin(origins= {"*"})
@RestController
public class RankController {
	private RankService rankService;
	
	@Autowired
	public void setRankService(RankService rankService) {
		this.rankService = rankService;
	}
	
	@PostMapping("/rank/user")
	public void getUserRank() {
		
	}
	
	@PostMapping("/rank/toilet")
	public void getToiletRank() {
		
	}
	
}
