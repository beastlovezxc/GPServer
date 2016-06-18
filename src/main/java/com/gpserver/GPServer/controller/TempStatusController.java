package com.gpserver.GPServer.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gpserver.GPServer.entity.TempStatus;
import com.gpserver.GPServer.service.TempStatusService;

@Controller
public class TempStatusController {

	@Resource
	TempStatusService service;
	
	@RequestMapping(value = "updateInroomInfo")
	public String updateInroomInfo(TempStatus tempStatus) {
		service.updateInroomInfo(tempStatus);
		
		return "updateInroomInfoSuccess";
	}
}
