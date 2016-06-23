package com.gpserver.GPServer.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gpserver.GPServer.entity.BugStatistic;
import com.gpserver.GPServer.entity.DeviceInfo;
import com.gpserver.GPServer.entity.StatusLog;
import com.gpserver.GPServer.entity.TempStatus;
import com.gpserver.GPServer.service.AutoGeneratingProgrammingService;
import com.gpserver.GPServer.service.BugStatisticService;
import com.gpserver.GPServer.service.DeviceInfoService;
import com.gpserver.GPServer.service.PushModifyService;
import com.gpserver.GPServer.service.StatusLogService;
import com.gpserver.GPServer.service.TempStatusService;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@Resource
	TempStatusService tempStatusService;
	@Resource
	BugStatisticService bugStatisticService;
	@Resource
	StatusLogService statusLogService;
	@Resource
	PushModifyService pushModifyService;
	@Resource
	DeviceInfoService deviceInfoService;
	@RequestMapping(value = "hello")
	public String helloWorld() {
		return "helloword";
	}
	
	
	@RequestMapping(value = "index")
	public String toIndexPage(ModelMap map) {

		map = doManyThings(map);
		return "index";
	}
	@RequestMapping(value = "pushHeartTemp")
	public String pushHeartTemp(ModelMap map) {
		TempStatus tempStatus = tempStatusService.getAllTemp();
		pushModifyService.sendHeartTempMessage(tempStatus.getHeartTemp());
		map = doManyThings(map);
		return "index";
	}
	@RequestMapping(value = "pushAirTemp")
	public String pushAirTemp(ModelMap map) {
		TempStatus tempStatus = tempStatusService.getAllTemp();
		pushModifyService.sendAirTempMessage(tempStatus.getAirTemp());
		map = doManyThings(map);
		return "index";
	}
	@RequestMapping(value = "pushElectricPower")
	public String pushElectricpower(ModelMap map) {
		TempStatus tempStatus = tempStatusService.getAllTemp();
		pushModifyService.sendElectricpowerMessage(tempStatus.getElectricpower());
		map = doManyThings(map);
		return "index";
	}
	@RequestMapping(value = "pushPowerCost")
	public String pushPowerCost(ModelMap map) {
		TempStatus tempStatus = tempStatusService.getAllTemp();
		pushModifyService.sendPowerCostMessage(tempStatus.getPowercost());
		map = doManyThings(map);
		return "index";
	}
	@RequestMapping(value = "editSetting")
	public String toEditSettingPage(ModelMap map) {
		return "editSetting";
	}
	
	/**
	 * 前台自动化请求脚本
	 * 自动生成数据
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "autoGeneratingProgram" ,method = RequestMethod.GET)
	public void autoGeneratingProgram() {
		int flag = (int)(Math.random()*4);
		if(flag < 2) {
			inroomInfoChange();
		} else {
			deviceErrorChange();
		}
		//return "redirect:../index";
	}
	/**
	 * 室内环境自动生成器
	 * @param map
	 * @return
	 */
	public void inroomInfoChange() {
		TempStatus tempStatus = new TempStatus();
		tempStatus.setAirTemp((float)Math.random()*100);
		tempStatus.setHeartTemp((float)Math.random()*100);
		tempStatus.setPowercost((float)Math.random()*1000);
		tempStatus.setElectricpower((float)Math.random()*10000);
		Timestamp d = new Timestamp(System.currentTimeMillis());
		tempStatus.setTimestamp(d);
		tempStatusService.insertInroomInfo(tempStatus);
		
		if(tempStatus.getAirTemp() > 30 || tempStatus.getAirTemp() < 15) {
			pushModifyService.sendAirTempMessage(tempStatus.getAirTemp());
		}
		if(tempStatus.getHeartTemp() < 50) {
			pushModifyService.sendHeartTempMessage(tempStatus.getHeartTemp());
		}
		if(tempStatus.getPowercost() > 200) {
			pushModifyService.sendPowerCostMessage(tempStatus.getPowercost());
		}
		if(tempStatus.getElectricpower() > 2000) {
			pushModifyService.sendElectricpowerMessage(tempStatus.getElectricpower());
		}
	}
	/**
	 * 设备故障生成器
	 * @param map
	 * @return
	 */
	public void deviceErrorChange() {
		List<DeviceInfo> deviceInfoList = deviceInfoService.selectAllDeviceInfo();
		DeviceInfo deviceInfo = new DeviceInfo();
		Boolean flag = false;
		for(int i = 0; i < deviceInfoList.size(); i++) {
			DeviceInfo di = deviceInfoList.get(i);
			if(di.getDeviceStatus() == 1) {
				flag = true;
				break;
			}
		}
		while(flag) {
			int random = (int)(Math.random()*deviceInfoList.size());
			deviceInfo = deviceInfoList.get(random);
			if(deviceInfo.getDeviceStatus() == 1)
				break;
		}
		if(flag) {
			deviceInfo.setDeviceStatus(0);;
			deviceInfoService.updateDevicecInfoById(deviceInfo.getDeviceId());
			statusLogService.insertLogWithBreak(deviceInfo.getDeviceId());
			bugStatisticService.insertBugStatisticLogByModify(deviceInfo.getDeviceId());
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			if(pushModifyService.pushMessage(deviceInfo.getDeviceId(),"于" + time +"出现故障").equals("success") ){
	
			}
		} else {
			return ;
		}
		
	}
	public ModelMap doManyThings(ModelMap map) {
		TempStatus tempStatus = tempStatusService.getAllTemp();
		List<BugStatistic> bugStatisticList = bugStatisticService.getAllBug();
		List<StatusLog> statusLogList = statusLogService.selectStatusLogList();
		map.put("airTemp", tempStatus.getAirTemp());
		map.put("heartTemp", tempStatus.getHeartTemp());
		map.put("powercost", tempStatus.getPowercost());
		map.put("electricpower", tempStatus.getElectricpower());
		map.put("bugStatisticList", bugStatisticList);
		map.put("statusLogList", statusLogList);
		return map;
	}
}
