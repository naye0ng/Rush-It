package com.rushit.model.vo;

import java.sql.Timestamp;

public class Review {
	
	int	id;
	String toilet_id;
	String user_id;
	String review;
	double rating;
	Timestamp timestamp;
	
	public Review() {};
	
	public Review(String toilet_id, String user_id, String review, double rating, Timestamp timestamp) {
		super();
		this.toilet_id = toilet_id;
		this.user_id = user_id;
		this.review = review;
		this.rating = rating;
		this.timestamp = timestamp;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", toilet_id=" + toilet_id + ", user_id=" + user_id + ", review=" + review
				+ ", rating=" + rating + ", timestamp=" + timestamp + "]";
	}

}
