package com.gpserver.GPServer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpserver.GPServer.dao.IDeviceInfoDao;
import com.gpserver.GPServer.entity.DeviceInfo;

@Service
public class DeviceInfoService {

	@Resource
	IDeviceInfoDao dao;
	public List<DeviceInfo> selectAllDeviceInfo() {
		// TODO Auto-generated method stub
		List<DeviceInfo> deviceInfo = dao.selectAllDeviceInfo();
		return deviceInfo;
	}

	public void updateDeviceInfo(DeviceInfo deviceInfo) {
		// TODO Auto-generated method stub
		dao.updateDeviceInfo(deviceInfo);
	}

	public void addDeviceInfo(DeviceInfo deviceInfo) {
		// TODO Auto-generated method stub
		dao.addDeviceInfo(deviceInfo);
	}

	public void deleteDeviceInfo(DeviceInfo deviceInfo) {
		// TODO Auto-generated method stub
		dao.deleteDeviceInfo(deviceInfo);
	}

	public void updateDevicecInfoById(int intValue) {
		// TODO Auto-generated method stub
		dao.updateDeviceInfoById(intValue);
	}

	public void resetSetting() {
		// TODO Auto-generated method stub
		dao.resetSetting();
	}

}
