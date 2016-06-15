package com.gpserver.GPServer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpserver.GPServer.dao.IDeviceInfoDao;
import com.gpserver.GPServer.entity.DeviceInfo;

@Service
public class PushModifyService {

	@Resource
	IDeviceInfoDao deviceInfoDao;
	
	

	public List<DeviceInfo> getNormalDeviceList() {
		// TODO Auto-generated method stub
		List<DeviceInfo> deviceInfoList = deviceInfoDao.getNormalDeviceList();
		return deviceInfoList;
	}
}
