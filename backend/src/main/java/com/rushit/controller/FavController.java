package com.rushit.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.FavService;
import com.rushit.model.vo.Fav;

@RestController
public class FavController {
	private FavService favService;
	
	@Autowired
	public void setFavService(FavService favService) {
		this.favService = favService;
	}
	
	@PostMapping("/fav")
	public HashMap<String, String> registerFav(@RequestParam String toilet_id, @RequestParam String user_id, @RequestParam int state){
		HashMap<String, String> Container = new HashMap<>();
		boolean favorite;
		if(state == 1) favorite = true;
		else favorite = false;
		Fav addFav = new Fav(toilet_id, user_id, favorite);
		
		if(favService.addFav(addFav)) {
			Container.put("code", "200");
		} else {
			Container.put("code", "Fail");
		}
		return Container;
	}
	
	@DeleteMapping("/fav")
	public HashMap<String, String> deleteLove(@RequestParam String toilet_id, @RequestParam String user_id) {
		HashMap<String, String> Container = new HashMap<>();
		Fav deleteFav = new Fav(toilet_id, user_id, true);
		
		if(favService.removeFav(deleteFav)) {
			Container.put("code", "200");
		} else {
			Container.put("code", "Fail");
		}
		return Container;
	}
}
