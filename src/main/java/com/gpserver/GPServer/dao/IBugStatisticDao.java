package com.gpserver.GPServer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gpserver.GPServer.entity.BugStatistic;

@Repository
public interface IBugStatisticDao {

	List<BugStatistic> getAllBug();

	void insertBugStatisticLogByModify(BugStatistic bugStatistic);

	List<BugStatistic> showBugStatisticList();

}
