package com.gpserver.GPServer.entity;

import java.sql.Timestamp;

public class UserInfo {

	
	/*
	 * 用户信息实体类
	 * 用户名，密码，权限（0：管理员，1:普通用户）
	 */
	private String userName;
	private String password;
	private int authority = 0;
	private Timestamp reg_time;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public Timestamp getReg_time() {
		return reg_time;
	}
	public void setReg_time(Timestamp reg_time) {
		this.reg_time = reg_time;
	}
	
	
}
