package com.gpserver.GPServer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpserver.GPServer.dao.ITempStatusDao;
import com.gpserver.GPServer.entity.TempStatus;

@Service
public class TempStatusService {

	@Resource
	ITempStatusDao dao;
	
	public TempStatus getAllTemp() {
		// TODO Auto-generated method stub
		return dao.getAllTemp();
	}

	public void updateInroomInfo(TempStatus tempStatus) {
		// TODO Auto-generated method stub
		dao.updateInroomInfo(tempStatus);
	}

	public void insertInroomInfo(TempStatus tempStatus) {
		// TODO Auto-generated method stub
		dao.insertInroomInfo(tempStatus);
	}


}
