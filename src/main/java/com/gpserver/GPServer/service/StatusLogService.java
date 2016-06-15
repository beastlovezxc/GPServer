package com.gpserver.GPServer.service;

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

}
