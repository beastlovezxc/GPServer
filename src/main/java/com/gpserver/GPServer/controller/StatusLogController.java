package com.gpserver.GPServer.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gpserver.GPServer.entity.StatusLog;
import com.gpserver.GPServer.service.StatusLogService;

@Controller
public class StatusLogController {

	
	@Resource
	StatusLogService service;
	
	@RequestMapping("statusLog")
	public String toStatusLogPage(HttpServletRequest request,ModelMap map) {
		List<StatusLog> statusLogList = service.selectStatusLogList();
		request.setAttribute("statusLogList", statusLogList);
		map.addAttribute("statusLogList", statusLogList);
		return "statusLog";
	}
}
