package com.rushit.model.vo;

public class Toilet {
	String id;
	String name;
	String location_x;
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

	@Override
	public String toString() {
		return "Toilet [id=" + id + ", name=" + name + ", location_x=" + location_x + ", location_y=" + location_y
				+ ", state=" + state + ", address=" + address + ", type=" + type + ", telephone=" + telephone
				+ ", time=" + time + ", handicapped=" + handicapped + ", diaper=" + diaper + ", bell=" + bell + "]";
	}
	
}
