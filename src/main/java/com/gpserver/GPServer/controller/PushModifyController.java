package com.gpserver.GPServer.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpserver.GPServer.entity.DeviceInfo;
import com.gpserver.GPServer.service.DeviceInfoService;
import com.gpserver.GPServer.service.PushModifyService;
import com.gpserver.GPServer.service.StatusLogService;

@Controller
public class PushModifyController {

	@Resource 
	PushModifyService pushModifyService;
	@Resource
	DeviceInfoService deviceInfoService;
	@Resource
	StatusLogService statusLogService;
	
	@RequestMapping(value="pushModify")
	public String toModifyPage(HttpServletRequest request,ModelMap map) {
		List<DeviceInfo> deviceInfoList = pushModifyService.getNormalDeviceList();
		map.addAttribute("deviceInfoList", deviceInfoList);
		request.setAttribute("deviceInfoList", deviceInfoList);
		return "modify";
	}
	
	
	@RequestMapping(value="sendMessage/{deviceId}")
	//@ResponseBody
	public String toIndexPage(@PathVariable("deviceId") Integer deviceId,HttpServletRequest request,ModelMap map) {
		Integer id = deviceId;
		try {
			deviceInfoService.updateDevicecInfoById(id.intValue());
			statusLogService.insertLogWithBreak(id.intValue());
			
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			if(pushModifyService.pushMessage(id.intValue(),"于" + time +"出现故障").equals("success") ){
				return "pushSuccess";
			}
			toModifyPage(request, map);
			
			
		} catch (Exception ex) {
			return "pushFail";
		}
		return "index";
	}
	@RequestMapping(value="sendMessage")
	public String toIndexPage() {
		return "index";
	}
}
