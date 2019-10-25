package com.rushit.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.LoveService;
import com.rushit.model.vo.Love;

@RequestMapping
@RestController
public class LoveController {
	private LoveService loveService;
	
	@Autowired
	public void setLoveService(LoveService loveService) {
		this.loveService = loveService;
	}
	
	@RequestMapping("/loveTest")
	public void root_test(HttpServletResponse response) throws Exception{
		response.getWriter().print("HELLO");
	}
		
	@GetMapping("/love")
	public ResponseEntity<Boolean> registerLove(@RequestParam String user_id, @RequestParam String toilet_id, @RequestParam int state){
		boolean like;
		if(state == 1) like = true;
		else like = false;
		Love love = new Love("test", "test", like);
		return loveService.addLove(love) ? new ResponseEntity<Boolean>(true, HttpStatus.OK) : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
	}
	
	@DeleteMapping("/love")
	public void deleteLove(@RequestParam Love love) {
		System.out.println("DELETE");
		loveService.removeLove(love);
	}
}
