package com.gpserver.GPServer.entity;

public class DeviceInfo {

	/*
	 * 设备信息实体类
	 * 设备名，设备状态，设备id，设备类型（1:视频设备，2:音频设备，3:消息设备）
	 */
	private String deviceName;
	private int deviceStatus;
	private int deviceId;
	private int type;
	private int subType;
	
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public int getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(int deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getSubType() {
		return subType;
	}
	public void setSubType(int subType) {
		this.subType = subType;
	}
	
	
}
