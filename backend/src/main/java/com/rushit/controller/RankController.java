package com.rushit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.RankService;
import com.rushit.model.vo.tRank;

@CrossOrigin(origins= {"*"})
@RestController
public class RankController {
	private RankService rankService; 

	@Autowired
	public void setRankService(RankService rankService) {
		this.rankService = rankService;
	}
	
	@GetMapping("/rank/toilet")
	public List<tRank> toiletRank() {
		return rankService.getToiletRank();
	}
}
