package com.gpserver.GPServer.entity;

import java.sql.Timestamp;

public class BugStatistic {

	private int deviceId;
	private String bugType;
	private Timestamp bugtime;
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getBugType() {
		return bugType;
	}
	public void setBugType(String bugType) {
		this.bugType = bugType;
	}
	public Timestamp getBugtime() {
		return bugtime;
	}
	public void setBugtime(Timestamp bugtime) {
		this.bugtime = bugtime;
	}
	
	
}
