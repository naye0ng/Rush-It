package com.rushit.model.service;

import java.util.HashMap;

import com.rushit.model.vo.User;

public interface UserService {
	
	
	Boolean addUser(User user);					// 회원가입
	User loginUser(User user);					// 로그인
	User findUser(String id);					// 유저 정보 찾기
	Boolean updateUser(User user);					// 닉네임 변경
	Boolean deleteUser(User user);				// 유저 삭제
	HashMap<String, String> checkNull(String id, String pw);	// 빈칸검사
	HashMap<String, String> checkUser(String id);	// 중복검사
}
