package com.gpserver.GPServer.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpserver.GPServer.dao.IStatusLogDao;
import com.gpserver.GPServer.entity.StatusLog;

@Service
public class StatusLogService {

	@Resource
	IStatusLogDao dao;
	
	public List<StatusLog> selectStatusLogList() {
		// TODO Auto-generated method stub
		List<StatusLog> statusLogList = dao.selectStatusLogList();
		return statusLogList;
	}

	public void insertLogWithBreak(int intValue) {
		// TODO Auto-generated method stub
		StatusLog statusLog = new StatusLog();
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		statusLog.setChangeDate(d);
		statusLog.setDeviceId(intValue);
		statusLog.setChangeStatus(0);
		statusLog.setBeforeStatus(1);
		dao.insertLogWithBreak(statusLog);
	}

}
