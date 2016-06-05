package com.gpserver.GPServer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpserver.GPServer.dao.IUserInfoDao;
import com.gpserver.GPServer.entity.UserInfo;

@Service
public class UserInfoService {

	@Resource
	IUserInfoDao dao;
	public UserInfo selectByUserName(UserInfo user) {
		// TODO Auto-generated method stub
		UserInfo us = dao.selectByUserName(user.getUserName());
		return us;
	}

	public void userRegister(UserInfo user) {
		// TODO Auto-generated method stub
		dao.userRegister(user);
		
	}

	public UserInfo doLogin(String userName) {
		// TODO Auto-generated method stub
		UserInfo userInfo = dao.doLogin(userName);
		return userInfo;
	}

}
