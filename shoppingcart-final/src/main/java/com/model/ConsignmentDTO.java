package com.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsignmentDTO
{
	public ConsignmentDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ConsignmentDTO [departure=" + departure + ", destination=" + destination + ", start_date=" + start_date
				+ ", start_time=" + start_time + ", distance=" + distance + ", travelspeed=" + travelspeed
				+ ", travel_break=" + travel_break + "]";
	}
	public ConsignmentDTO(String departure, String destination, LocalDate start_date, LocalTime start_time,
			int distance, int travelspeed, int travel_break) {
		super();
		this.departure = departure;
		this.destination = destination;
		this.start_date = start_date;
		this.start_time = start_time;
		this.distance = distance;
		this.travelspeed = travelspeed;
		this.travel_break = travel_break;
	}
	private String departure;
	private String destination;
	private LocalDate start_date;
	private LocalTime start_time;
	private int distance;
	private int travelspeed;
	private int travel_break;
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalTime getStart_time() {
		return start_time;
	}
	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getTravelspeed() {
		return travelspeed;
	}
	public void setTravelspeed(int travelspeed) {
		this.travelspeed = travelspeed;
	}
	public int getTravel_break() {
		return travel_break;
	}
	public void setTravel_break(int travel_break) {
		this.travel_break = travel_break;
	}
	
	

}
