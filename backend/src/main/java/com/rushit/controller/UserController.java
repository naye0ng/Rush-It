package com.rushit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<HashMap<String, String>> RegisterUser(String id, String pw, String nick, String gender){		
		HashMap<String, String> Container = new HashMap<>();
		User newUserInfo = new User(id, nick, pw, gender);
		Container = userService.checkUser(newUserInfo.getId());
		if(!Container.get("code").equals("300")) {
			if(userService.addUser(newUserInfo)) {
				Container.put("id", newUserInfo.getId());
				Container.put("nick", newUserInfo.getNick());
				Container.put("code", "200");
				Container.put("message", "Register user success");
			}
		} else {
			Container.put("message", "Duplicate user id");
		}
		return new ResponseEntity<HashMap<String, String>>(Container, HttpStatus.OK);
	}
	
	@GetMapping("/rank/user")
	public HashMap<String, Object> RankUser(@RequestParam String user_id){
		HashMap<String, Object> ret = new HashMap<>();
		HashMap<String, Object> userRank=rs.selectRank(user_id);
		List<HashMap<String, Object>> list=rs.selectTopTen();
		System.out.println(list.toString());
		for(int i=0; i<list.size(); i++) {
			HashMap<String, Object> hash= list.get(i);
			hash.put("ranking", Math.round((Double) hash.get("ranking")));
		}
		if(list.size()==0) {
			ret.put("rank", "리뷰가 없습니다.");
		}
		else {
			ret.put("rank",list);
		}
		if(userRank==null) {
			ret.put("myrank", "꼴등");
		}
		else {
			userRank.put("ranking", Math.round((Double) userRank.get("ranking")));
			ret.put("myrank", userRank);
		}
		ret.put("code", 200);
		
		return ret;
	}

	@PostMapping("/user/{id}")
	public ResponseEntity<HashMap<String, String>> LoginUser(@PathVariable String id, String pw) {
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
			Container.put("message", "Update user nickname success");
		}	
		else {
			Container.put("code", "301");
			Container.put("message", "User doesn't Exist");
		}
		return new ResponseEntity<HashMap<String, String>>(Container, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<HashMap<String, String>> DeleteUser(@PathVariable String id, String pw) {
		HashMap<String, String> Container = new HashMap<>();
		User deleteUserInfo = new User();
		deleteUserInfo.setId(id);
		deleteUserInfo.setPw(pw);
		if(userService.deleteUser(deleteUserInfo)) {
			Container.put("code", "200");
			Container.put("message", "Delete user success");
		} else {
			Container.put("code", "301");
			Container.put("message", "User doesn't Exist");
		}
		return new ResponseEntity<HashMap<String, String>>(Container, HttpStatus.OK);
	}
}
