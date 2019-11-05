package com.rushit.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.FavService;
import com.rushit.model.vo.Fav;

@CrossOrigin(origins= {"*"})
@RestController
public class FavController {
	private FavService favService;
	
	@Autowired
	public void setFavService(FavService favService) {
		this.favService = favService;
	}
	
	@PostMapping("/fav")		//post
	public HashMap<String, String> registerFav(@RequestParam String toilet_id, @RequestParam String user_id, @RequestParam int state){
		HashMap<String, String> Container = new HashMap<>();
				
		Boolean favorite;
		if(state == 1) favorite = true;
		else if(state == -1) favorite = false;
		else favorite = null;
		
		HashMap<String, String> checkFav = new HashMap<>();
		checkFav.put("toilet_id", toilet_id);
		checkFav.put("user_id", user_id);
		Fav recInfo = favService.selectFav(checkFav);
		
		Fav favInfo = new Fav(toilet_id, user_id, favorite);		

		if(recInfo == null) { // add
			favService.addFav(favInfo);
			Container.put("message", "Add Favorite Toilet Success");
		}
		else if(recInfo.isFav() == favorite) { // delete
			favService.removeFav(favInfo);
			Container.put("message", "Delete Favorite Toilet Success");
		}
		else if(recInfo.isFav() != favorite) { // update
			favService.modifyFav(favInfo);
			Container.put("message", "Update Favorite Toilet Success");
		}
		Container.put("code", "200");
		return Container;			
	}
	

	@DeleteMapping("/fav")
	public HashMap<String, String> deleteFav(@RequestParam String toilet_id, @RequestParam String user_id) {
		HashMap<String, String> Container = new HashMap<>();
		Fav favInfo = new Fav(toilet_id, user_id, true);
		
		if(favService.removeFav(favInfo)) {
			Container.put("code", "200");
			Container.put("message", "Success");
		} else {
			Container.put("code", "301");
			Container.put("message", "Data doesn't exist in the DB");
		}
		return Container;
	}
}
