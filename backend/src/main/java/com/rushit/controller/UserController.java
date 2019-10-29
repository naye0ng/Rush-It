package com.rushit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.UserService;
import com.rushit.model.vo.User;

@RestController
public class UserController {
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/user")
	public void RegisterUser(@RequestBody User newUserInfo) {		
		System.out.println(newUserInfo);
		System.out.println();
		if(userService.addUser(newUserInfo)) {
			System.out.println("Add Newbie Success");
			AutoLogin(newUserInfo);
		} else {
			System.out.println("Fail to Add Newbie");
		}
	}
	
	public User AutoLogin(User UserInfo) {
		return userService.loginUser(UserInfo);
	}

	@PostMapping("/user/{id}")
	public User LoginUser(@PathVariable String id, @RequestBody String pw) {
		User loginUserInfo = new User();
		loginUserInfo.setId(id);
		loginUserInfo.setPw(pw);
		return userService.loginUser(loginUserInfo);
	}
	
	@PutMapping("/user/{id}")
	public User ModifyUser(@PathVariable String id, @RequestBody String nick) {
		User modifyUserInfo = new User();
		modifyUserInfo.setId(id);
		modifyUserInfo.setNick(nick);
		return userService.updateUser(modifyUserInfo);
	}
	
	@DeleteMapping("/user/{id}")
	public void DeleteUser(@PathVariable String id, @RequestBody String pw) {
		User deleteUserInfo = new User();
		System.out.println(id);
		System.out.println(pw);
		deleteUserInfo.setId(id);
		deleteUserInfo.setPw(pw);
		if(userService.deleteUser(deleteUserInfo)) {
			System.out.println("Delete User Success");
		} else {
			System.out.println("Fail to Delete User");
		}
	}
}
