package com.gpserver.GPServer.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gpserver.GPServer.dao.ITempStatusDao;
import com.gpserver.GPServer.entity.TempStatus;
import com.gpserver.GPServer.service.TempStatusService;

@Controller
public class IndexController {
	
	@Resource
	TempStatusService tempStatusService;
	@RequestMapping(value = "hello")
	public String helloWorld() {
		return "helloword";
	}
	
	
	@RequestMapping(value = "index")
	public String toIndexPage(ModelMap map) {
		TempStatus tempStatus = tempStatusService.getAllTemp();
		map.put("airTemp", tempStatus.getAirTemp());
		map.put("heartTemp", tempStatus.getHeartTemp());
		map.put("powercost", tempStatus.getPowercost());
		map.put("electricpower", tempStatus.getElectricpower());
		return "index";
	}
	
}
