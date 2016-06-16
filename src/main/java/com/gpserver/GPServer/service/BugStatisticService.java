package com.gpserver.GPServer.service;

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

}
