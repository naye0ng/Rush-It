package com.rushit.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/usertest")
	public void test(HttpServletResponse response) throws IOException {
		response.getWriter().print("hello");
	}
	
	@PostMapping("/user")
	public HashMap<String, String> RegisterUser(@RequestParam String id, @RequestParam String pw, @RequestParam String nick, @RequestParam String gender){		
		HashMap<String, String> Container = new HashMap<>();
		User newUserInfo = new User(id, nick, pw, gender);
		Container = userService.checkUser(newUserInfo.getId());
		if(!Container.get("code").equals("300")) {
			if(userService.addUser(newUserInfo)) {
				Container.put("id", newUserInfo.getId());
				Container.put("nick", newUserInfo.getNick());
				Container.put("code", "200");
			}
		}
		return Container;
	}

	@PostMapping("/user/{id}")
	public HashMap<String, String> LoginUser(@PathVariable String id, @RequestParam String pw) {
		HashMap<String, String> Container = new HashMap<>();
		User loginUserInfo = new User();
		loginUserInfo.setId(id);
		loginUserInfo.setPw(pw);
		
		Container = userService.loginUser(loginUserInfo);
		return Container;
	}
	
	@PutMapping("/user/{id}")
	public HashMap<String, String> ModifyUser(@PathVariable String id, @RequestParam String nick) {
		HashMap<String, String> Container = new HashMap<>();
		User modifyUserInfo = new User();
		modifyUserInfo.setId(id);
		modifyUserInfo.setNick(nick);
		if(userService.updateUser(modifyUserInfo)) {
			Container.put("code", "200");
			Container.put("id", id);
			Container.put("nick", nick);
		}	
		else {
			Container.put("code", "301");
		}
		return Container;
	}
	
	@DeleteMapping("/user/{id}")
	public HashMap<String, String> DeleteUser(@PathVariable String id, @RequestParam String pw) {
		HashMap<String, String> Container = new HashMap<>();
		User deleteUserInfo = new User();
		deleteUserInfo.setId(id);
		deleteUserInfo.setPw(pw);
		if(userService.deleteUser(deleteUserInfo)) {
			Container.put("code", "200");
		} else {
			Container.put("code", "301");
		}
		return Container;
	}
}
