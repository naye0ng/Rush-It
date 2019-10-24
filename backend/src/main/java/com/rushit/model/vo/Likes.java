package com.rushit.model.vo;

public class Likes {

	String toilet_id;
	String user_id;
	boolean likes;
	
	public Likes() {
		
	};
	public Likes(String toilet_id, String user_id, boolean likes) {
		super();
		this.toilet_id = toilet_id;
		this.user_id = user_id;
		this.likes = likes;
	}
	
	public String getToilet_id() {
		return toilet_id;
	}
	public void setToilet_id(String toilet_id) {
		this.toilet_id = toilet_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public boolean isLike() {
		return likes;
	}
	public void setLike(boolean likes) {
		this.likes = likes;
	}
	
	@Override
	public String toString() {
		return "Like [toilet_id=" + toilet_id + ", user_id=" + user_id + ", like=" + likes + "]";
	}
	
}
