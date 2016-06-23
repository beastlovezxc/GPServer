package com.gpserver.GPServer.entity;

import java.sql.Timestamp;

public class StatusLog {

	private Timestamp changeDate;
	private int deviceId;
	private int beforeStatus;
	private int changeStatus;
	private int logId;
	public Timestamp getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getBeforeStatus() {
		return beforeStatus;
	}
	public void setBeforeStatus(int beforeStatus) {
		this.beforeStatus = beforeStatus;
	}
	public int getChangeStatus() {
		return changeStatus;
	}
	public void setChangeStatus(int changeStatus) {
		this.changeStatus = changeStatus;
	}
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	
	
}
