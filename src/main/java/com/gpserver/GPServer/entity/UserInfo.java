package com.gpserver.GPServer.entity;

public class UserInfo {

	
	/*
	 * 用户信息实体类
	 * 用户名，密码，权限（0：管理员，1:普通用户）
	 */
	private String userName;
	private String password;
	private int authority = 0;
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
	
	
}
