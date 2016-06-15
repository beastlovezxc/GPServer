package com.gpserver.GPServer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gpserver.GPServer.entity.DeviceInfo;

@Repository
public interface IDeviceInfoDao {

	List<DeviceInfo> selectAllDeviceInfo();

	void addDeviceInfo(DeviceInfo deviceInfo);

	void updateDeviceInfo(DeviceInfo deviceInfo);

	void deleteDeviceInfo(DeviceInfo deviceInfo);

	List<DeviceInfo> getNormalDeviceList();

}
