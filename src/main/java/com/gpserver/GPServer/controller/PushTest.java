package com.gpserver.GPServer.controller;

import javax.annotation.Resource;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gpserver.GPServer.service.PushTestService;

@Controller
public class PushTest {

	@Resource
	PushTestService service;
	
	@RequestMapping("pushtest")
	public String toPushTest() {
		service.testSendPush();
		return "index";
	}
}
