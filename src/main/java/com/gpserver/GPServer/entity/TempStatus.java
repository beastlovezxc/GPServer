package com.gpserver.GPServer.entity;

import java.sql.Timestamp;

public class TempStatus {

	private float airTemp;
	private float heartTemp;
	private float powercost;
	private float electricpower;
	private Timestamp timestamp;
	
	public float getAirTemp() {
		return airTemp;
	}
	public void setAirTemp(float airTemp) {
		this.airTemp = airTemp;
	}
	public float getHeartTemp() {
		return heartTemp;
	}
	public void setHeartTemp(float heartTemp) {
		this.heartTemp = heartTemp;
	}
	public float getPowercost() {
		return powercost;
	}
	public void setPowercost(float powercost) {
		this.powercost = powercost;
	}
	public float getElectricpower() {
		return electricpower;
	}
	public void setElectricpower(float electricpower) {
		this.electricpower = electricpower;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
