package com.gpserver.GPServer.entity;

import java.security.Timestamp;

public class User {

	private String username;
	private String password;
	private Timestamp reg_time;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getReg_time() {
		return reg_time;
	}
	public void setReg_time(Timestamp reg_time) {
		this.reg_time = reg_time;
	}
	
	
}
