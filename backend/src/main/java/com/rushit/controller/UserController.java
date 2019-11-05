package com.rushit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.ReviewService;
import com.rushit.model.service.UserService;
import com.rushit.model.vo.User;

@CrossOrigin(origins= {"*"})
@RestController
public class UserController {
	private UserService userService;
	private ReviewService rs;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setRs(ReviewService rs) {
		this.rs = rs;
	}

	@GetMapping("/usertest")
	public void test(HttpServletResponse response) throws IOException {
		response.getWriter().print("hello");
	}
	
	@PostMapping("/user")
	public ResponseEntity<HashMap<String, String>> RegisterUser(@RequestParam String id, @RequestParam String pw, @RequestParam String nick, @RequestParam String gender){		
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
		return new ResponseEntity<HashMap<String, String>>(Container, HttpStatus.OK);
	}
	
	@GetMapping("/rank/user")
	public ResponseEntity<HashMap<String, Object>> RankUser(@RequestParam String user_id){
		HashMap<String, Object> ret = new HashMap<>();
		HashMap<String, Object> userRank=rs.selectRank(user_id);
		userRank.put("ranking", Math.round((Double) userRank.get("ranking")));
		List<HashMap<String, Object>> list=rs.selectTopTen();
		System.out.println(list.toString());
		System.out.println(userRank.toString());
		for(int i=0; i<list.size(); i++) {
			HashMap<String, Object> hash= list.get(i);
			hash.put("ranking", Math.round((Double) hash.get("ranking")));
		}
		ret.put("rank", list);
		ret.put("myrank", userRank);
		return new ResponseEntity<HashMap<String, Object>>(ret, HttpStatus.OK);
	}

	@PostMapping("/user/{id}")
	public ResponseEntity<HashMap<String, String>> LoginUser(@PathVariable String id, @RequestParam String pw) {
		HashMap<String, String> Container = new HashMap<>();
		User loginUserInfo = new User();
		loginUserInfo.setId(id);
		loginUserInfo.setPw(pw);
		
		Container = userService.loginUser(loginUserInfo);
		return new ResponseEntity<HashMap<String, String>>(Container, HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<HashMap<String, String>> ModifyUser(@PathVariable String id, @RequestParam String nick) {
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
		return new ResponseEntity<HashMap<String, String>>(Container, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<HashMap<String, String>> DeleteUser(@PathVariable String id, @RequestParam String pw) {
		HashMap<String, String> Container = new HashMap<>();
		User deleteUserInfo = new User();
		deleteUserInfo.setId(id);
		deleteUserInfo.setPw(pw);
		if(userService.deleteUser(deleteUserInfo)) {
			Container.put("code", "200");
		} else {
			Container.put("code", "301");
		}
		return new ResponseEntity<HashMap<String, String>>(Container, HttpStatus.OK);
	}
}
