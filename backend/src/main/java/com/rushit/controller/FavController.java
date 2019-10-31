package com.rushit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.FavService;
import com.rushit.model.vo.Fav;

@RestController
@RequestMapping("/fav")
public class FavController {
	private FavService favService;
	
	@Autowired
	public void setFavService(FavService favService) {
		this.favService = favService;
	}
	
	@GetMapping("/add")
	public ResponseEntity<Boolean> registerFav(@RequestParam String toilet_id, @RequestParam String user_id, @RequestParam int state){
		boolean favorite;
		if(state == 1) favorite = true;
		else favorite = false;
		Fav addFav = new Fav(toilet_id, user_id, favorite);
		return favService.addFav(addFav) ? new ResponseEntity<Boolean>(true, HttpStatus.OK) : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
	}
	
	@DeleteMapping("/fav")
	public void deleteLove(@RequestParam String user_id, @RequestParam String toilet_id) {
		Fav deleteFav = new Fav();
		deleteFav.setUser_id(user_id);
		deleteFav.setToilet_id(toilet_id);
		System.out.println("DELETE");
		favService.removeFav(deleteFav);
	}
}
