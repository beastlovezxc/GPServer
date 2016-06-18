package com.gpserver.GPServer.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gpserver.GPServer.entity.BugStatistic;
import com.gpserver.GPServer.service.BugStatisticService;

@Controller
public class BugStatisticController {

	@Resource
	BugStatisticService service;
	
	@RequestMapping(value = "showBugStatisticList")
	public String showBugStatisticList(ModelMap map) {
		List<BugStatistic> bugStatisticList =  service.showBugStatisticList();
		map.addAttribute("bugStatisticList", bugStatisticList);
		return "showBugStatisticList";
	}
}
