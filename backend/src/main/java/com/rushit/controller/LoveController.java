package com.rushit.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/loveGet")
	public void selectLike() {
		System.out.println("SELECT");
		System.out.println(loveService.getAllLove());
	}
	
	
	@GetMapping("/lovAdd")
	public ResponseEntity<Boolean> registerLove(){
		Love love = new Love("test", "test", true);
		System.out.println("INSERT");
		return loveService.addLove(love) ? new ResponseEntity<Boolean>(true, HttpStatus.OK) : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
		
	}
	
	@RequestMapping("/loveDelete")
	public void deleteLove(@RequestBody Love love) {
		System.out.println("DELETE");
		loveService.removeLove(love);
	}
}
