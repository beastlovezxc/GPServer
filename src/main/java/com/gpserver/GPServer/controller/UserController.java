package com.gpserver.GPServer.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.gpserver.GPServer.entity.User;
import com.gpserver.GPServer.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {

	@Resource
	UserService service;
	
	@RequestMapping("login.do")
	public String toLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "doLogin.do", method = RequestMethod.POST)
	public String doLogin(@RequestParam String username, @RequestParam String password,HttpServletRequest request, ModelMap map) {
		try {
			User user = service.doLogin(username,password);
			map.put("user", user);
			
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			return "login";
		}
		return "loginsuccess";
	}
	
	@RequestMapping("doLogout.do")
	public String doLogout(SessionStatus status) {
		status.setComplete();
		return "login";
	}
}
