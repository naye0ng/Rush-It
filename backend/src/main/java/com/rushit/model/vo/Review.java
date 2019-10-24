package com.rushit.model.vo;

public class Review {
	
	int	id;
	String toilet_id;
	String user_id;
	String review;
	double rating;
	String timestamp;
	
	public Review() {};
	
	public Review(int id, String toilet_id, String user_id, String review, double rating, String timestamp) {
		super();
		this.id = id;
		this.toilet_id = toilet_id;
		this.user_id = user_id;
		this.review = review;
		this.rating = rating;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", toilet_id=" + toilet_id + ", user_id=" + user_id + ", review=" + review
				+ ", rating=" + rating + ", timestamp=" + timestamp + "]";
	}
	
}
