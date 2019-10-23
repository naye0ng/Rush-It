package com.team3.model.vo;

public class User {
	
	private String id;
	private String nick;
	private String pw;
	private String gender;
	
	public User() {
	}
	
	public User(String id, String nick, String pw, String gender) {
		super();
		this.id = id;
		this.nick = nick;
		this.pw = pw;
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nick=" + nick + ", pw=" + pw + ", gender=" + gender + "]";
	}

}
