package com.gpserver.GPServer.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.gpserver.GPServer.entity.BugStatistic;
import com.gpserver.GPServer.entity.StatusLog;
import com.gpserver.GPServer.entity.TempStatus;
import com.gpserver.GPServer.entity.UserInfo;
import com.gpserver.GPServer.service.BugStatisticService;
import com.gpserver.GPServer.service.StatusLogService;
import com.gpserver.GPServer.service.TempStatusService;
import com.gpserver.GPServer.service.UserInfoService;

@Controller
@SessionAttributes("user")
public class UserInfoController {

	@Resource
	UserInfoService service;
	@Resource 
	TempStatusService tempStatusService;
	@Resource
	BugStatisticService bugStatisticService;
	@Resource
	StatusLogService statusLogService;
	@RequestMapping(value = "userregister")
	public String userRegister() {
		return "/register";
	}
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String userRegister(HttpServletRequest request, HttpServletResponse response,UserInfo user,ModelMap map) {
		
		UserInfo us = service.selectByUserName(user);
		if(us != null) {
			map.addAttribute("regStatus","用户名已经存在！");
			return "/register";
		} else {
			service.userRegister(user);
			map.addAttribute("regStatus", "注册成功！");
			map.addAttribute("user", user.getUserName());
			return "/registersuccess";
		}
	}
	@RequestMapping(value = "login")
	public String toLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String doLogin(UserInfo user,HttpServletRequest request,ModelMap map) {
		try{
			UserInfo userInfo = service.doLogin(user.getUserName());
			if(user.getUserName().equals(userInfo.getUserName()) && user.getPassword().equals(userInfo.getPassword())) {
				TempStatus tempStatus = tempStatusService.getAllTemp();
				List<BugStatistic> bugStatisticList = bugStatisticService.getAllBug();
				List<StatusLog> statusLogList = statusLogService.selectStatusLogList();
				map.put("airTemp", tempStatus.getAirTemp());
				map.put("heartTemp", tempStatus.getHeartTemp());
				map.put("powercost", tempStatus.getPowercost());
				map.put("electricpower", tempStatus.getElectricpower());
				map.put("bugStatisticList", bugStatisticList);
				map.put("statusLogList", statusLogList);
				map.put("user", user.getUserName());
				return "index";
			} else {
				request.setAttribute("error", "用户名不存在或密码错误！");
				return "login";
			}
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			return "login";
		}
	}
	@RequestMapping(value="pushSuccess") 
	public String toPushSuccessPage() {
		return "pushSuccess";
	}
	@RequestMapping(value = "doLogout")
	public String doLogout(SessionStatus status) {
		status.setComplete();
		return "login";
	}
}
