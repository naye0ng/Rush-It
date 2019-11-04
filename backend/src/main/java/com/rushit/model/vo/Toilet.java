package com.rushit.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Toilet {
	String id;
	String name;
	@JsonProperty
	String location_x;
	@JsonProperty
	String location_y;
	String state;
	String address;
	int type;
	String telephone;
	String time;
	boolean handicapped;
	boolean diaper;
	boolean bell;
	
	public Toilet() {
	}

	public Toilet(String id, String name, String location_x, String location_y, String state, String address, int type,
			String telephone, String time, boolean handicapped, boolean diaper, boolean bell) {
		super();
		this.id = id;
		this.name = name;
		this.location_x = location_x;
		this.location_y = location_y;
		this.state = state;
		this.address = address;
		this.type = type;
		this.telephone = telephone;
		this.time = time;
		this.handicapped = handicapped;
		this.diaper = diaper;
		this.bell = bell;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation_x() {
		return location_x;
	}

	public void setLocation_x(String location_x) {
		this.location_x = location_x;
	}

	public String getLocation_y() {
		return location_y;
	}

	public void setLocation_y(String location_y) {
		this.location_y = location_y;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isHandicapped() {
		return handicapped;
	}

	public void setHandicapped(boolean handicapped) {
		this.handicapped = handicapped;
	}

	public boolean isDiaper() {
		return diaper;
	}

	public void setDiaper(boolean diaper) {
		this.diaper = diaper;
	}

	public boolean isBell() {
		return bell;
	}

	public void setBell(boolean bell) {
		this.bell = bell;
	}

	@Override
	public String toString() {
		return "Toilet [id=" + id + ", name=" + name + ", location_x=" + location_x + ", location_y=" + location_y
				+ ", state=" + state + ", address=" + address + ", type=" + type + ", telephone=" + telephone
				+ ", time=" + time + ", handicapped=" + handicapped + ", diaper=" + diaper + ", bell=" + bell + "]";
	}
	
}
