package com.rushit.model.vo;

public class Fav {

	private String toilet_id;
	private String user_id;
	private Boolean fav;
	
	public Fav() {
		
	};
	public Fav(String toilet_id, String user_id, boolean fav) {
		super();
		setToilet_id(toilet_id);
		setUser_id(user_id);
		setFav(fav);
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
	public void setFav(Boolean favor) {
		this.fav = favor;
	}
	public boolean isFav() {
		return fav;
	}
	
	@Override
	public String toString() {
		return "Like [toilet_id=" + toilet_id + ", user_id=" + user_id + ", fav=" + fav + "]";
	}
	
}
