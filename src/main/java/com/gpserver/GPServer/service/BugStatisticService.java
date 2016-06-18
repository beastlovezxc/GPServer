package com.gpserver.GPServer.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpserver.GPServer.dao.IBugStatisticDao;
import com.gpserver.GPServer.entity.BugStatistic;

@Service
public class BugStatisticService {

	@Resource
	IBugStatisticDao dao;
	public List<BugStatistic> getAllBug() {
		// TODO Auto-generated method stub
		List<BugStatistic> bugStatistic = dao.getAllBug();
		return bugStatistic;
	}
	public void insertBugStatisticLogByModify(int intValue) {
		// TODO Auto-generated method stub
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		BugStatistic bugStatistic = new BugStatistic();
		bugStatistic.setDeviceId(intValue);
		bugStatistic.setBugtime(d);
		bugStatistic.setBugType("2");
		dao.insertBugStatisticLogByModify(bugStatistic);
	}
	public List<BugStatistic> showBugStatisticList() {
		// TODO Auto-generated method stub
		return dao.showBugStatisticList();
	}

}
