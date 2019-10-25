package com.rushit.model.vo;

public class Love {

	private String toilet_id;
	private String user_id;
	private boolean love;
	
	public Love() {
		
	};
	public Love(String toilet_id, String user_id, boolean love) {
		super();
		setToilet_id(toilet_id);
		setUser_id(user_id);
		setLove(love);
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
	public boolean isLove() {
		return love;
	}
	public void setLove(boolean love) {
		this.love = love;
	}
	
	@Override
	public String toString() {
		return "Like [toilet_id=" + toilet_id + ", user_id=" + user_id + ", love=" + love + "]";
	}
	
}
