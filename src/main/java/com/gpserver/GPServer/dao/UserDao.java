package com.gpserver.GPServer.dao;

import org.springframework.stereotype.Repository;

import com.gpserver.GPServer.entity.User;

@Repository
public class UserDao {

	public User selectByUsername(String username) {
		// TODO Auto-generated method stub
		//admin
		if("admin".equals(username)) {
			User user = new User();
			user.setPassword("123");
			user.setUsername("admin");
			return user;
		}
		return null;
	}

}
