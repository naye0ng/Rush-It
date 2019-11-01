package com.rushit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rushit.model.service.ToiletService;

@Controller
public class ToiletController {
	private ToiletService toiletService;
	
	@Autowired
	public void setLikeService(ToiletService toiletService) {
		this.toiletService = toiletService;
	}
	
	@ResponseBody
	@GetMapping("/toilet")
	public Map<String, String> jsonReturnSample() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "111");
		map.put("age", "222");
		return map;
	}
	
	
}
