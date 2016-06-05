package com.gpserver.GPServer.dao;

import org.springframework.stereotype.Repository;

import com.gpserver.GPServer.entity.UserInfo;

@Repository
public interface IUserInfoDao {

	UserInfo selectByUserName(String userName);

	void userRegister(UserInfo user);

	UserInfo doLogin(String userName);
	
}
