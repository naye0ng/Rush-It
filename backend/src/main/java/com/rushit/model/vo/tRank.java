package com.rushit.model.vo;

public class tRank extends Toilet {
	private String reviews;
	private Double ratings;
	
	public tRank() {
		
	}
	
	public tRank(String id, String name, String location_x, String location_y, String state, String address, int type,
			String telephone, String time, boolean handicapped, boolean diaper, boolean bell, String reviews, Double ratings) {
		super();
		setId(id);
		setName(name);
		setType(type);
		setState(state);
		setAddress(address);
		setLocation_x(location_x);
		setLocation_y(location_y);
		setHandicapped(handicapped);
		setDiaper(diaper);
		setBell(bell);
		setReviews(reviews);
		setRatings(ratings);
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}
	
	@Override
	public String toString() {
		return "Toilet [id=" + id + ", name=" + name + ", location_x=" + location_x + ", location_y=" + location_y
				+ ", state=" + state + ", address=" + address + ", type=" + type + ", telephone=" + telephone
				+ ", time=" + time + ", handicapped=" + handicapped + ", diaper=" + diaper + ", bell=" + bell + ", reviews= + reviews" + ", ratings  " + ratings + "]";
	}
}
