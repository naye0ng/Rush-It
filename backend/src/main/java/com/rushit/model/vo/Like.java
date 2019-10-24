package com.rushit.model.vo;

public class Like {

	String toilet_id;
	String user_id;
	boolean like;
	
	public Like() {};
	public Like(String toilet_id, String user_id, boolean like) {
		super();
		this.toilet_id = toilet_id;
		this.user_id = user_id;
		this.like = like;
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
		return like;
	}
	public void setLike(boolean like) {
		this.like = like;
	}
	
	@Override
	public String toString() {
		return "Like [toilet_id=" + toilet_id + ", user_id=" + user_id + ", like=" + like + "]";
	}
	
}
