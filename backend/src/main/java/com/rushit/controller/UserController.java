package com.rushit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.UserService;
import com.rushit.model.vo.User;


@RequestMapping
@RestController
public class UserController {
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void RegisterUser(@RequestParam String id, @RequestParam String nick, @RequestParam String pw, @RequestParam String gender) {
		User newbie = new User(id, nick, pw, gender);
		newbie = userService.addUser(newbie);
		LoginUser(newbie.getId(), newbie.getPw());
	}

	public User LoginUser(@PathVariable String id, @RequestParam String pw) {
		return userService.loginUser(id, pw);
	}
	
	public User ModifyUser(@PathVariable String id, @RequestParam String nick) {
		return userService.updateUser(id, nick);
	}
}
