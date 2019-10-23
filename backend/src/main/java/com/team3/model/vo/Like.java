package com.team3.model.vo;

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
	@Override
	public String toString() {
		return "Like [toilet_id=" + toilet_id + ", user_id=" + user_id + ", like=" + like + "]";
	}
	
}
