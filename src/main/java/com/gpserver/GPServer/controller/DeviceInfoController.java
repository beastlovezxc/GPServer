package com.gpserver.GPServer.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gpserver.GPServer.entity.DeviceInfo;
import com.gpserver.GPServer.service.DeviceInfoService;

@Controller
public class DeviceInfoController {

	@Resource
	DeviceInfoService service;
	
	@RequestMapping(value = "showAllDeviceInfo")
	public String showDeviceInfoList(HttpServletRequest request,ModelMap map) {
		List<DeviceInfo> deviceInfoList = service.selectAllDeviceInfo();
		map.addAttribute("deviceInfoList", deviceInfoList);
		request.setAttribute("deviceInfoList", deviceInfoList);
		return "showAllDeviceInfo";
	}
	
	@RequestMapping(value = "addDeviceInfo")
	public String addDeviceInfo() {
		return "addDeviceInfo";
	}
	@RequestMapping(value = "doAddDeviceInfo", method = RequestMethod.POST)
	public String doAddDeviceInfo(DeviceInfo deviceInfo) {
		deviceInfo.setDeviceStatus(1);
		service.addDeviceInfo(deviceInfo);
		return "addDeviceInfoSuccess";
	}
	@RequestMapping(value = "updateDeviceInfo")
	public String updateDevieInfo() {
		return "doUpdateDeviceInfo";
	}
	@RequestMapping(value = "doUpdateDeviceinfo")
	public String doUpdateDeviceInfo(DeviceInfo deviceInfo) {
		service.updateDeviceInfo(deviceInfo);
		return "home";
	}
	@RequestMapping(value = "deleteDeviceInfo")
	public String deleteDeviceInfo() {
		return "doDeleteDeviceInfo";
	}
	@RequestMapping(value = "doDeleteDeviceInfo")
	public String doDeleteDeviceInfo(DeviceInfo deviceInfo) {
		service.deleteDeviceInfo(deviceInfo);
		return "home";
	}
	@RequestMapping(value = "reset")
	public String resetSetting() {
		service.resetSetting();
		return "resetSuccess";
	}
	
}
