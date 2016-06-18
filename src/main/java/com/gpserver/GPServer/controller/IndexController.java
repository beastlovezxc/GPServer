package com.gpserver.GPServer.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gpserver.GPServer.entity.BugStatistic;
import com.gpserver.GPServer.entity.StatusLog;
import com.gpserver.GPServer.entity.TempStatus;
import com.gpserver.GPServer.service.BugStatisticService;
import com.gpserver.GPServer.service.PushModifyService;
import com.gpserver.GPServer.service.StatusLogService;
import com.gpserver.GPServer.service.TempStatusService;

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
