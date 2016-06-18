package com.gpserver.GPServer.dao;

import org.springframework.stereotype.Repository;

import com.gpserver.GPServer.entity.TempStatus;

@Repository
public interface ITempStatusDao {

	TempStatus getAllTemp();

	void updateInroomInfo(TempStatus tempStatus);

}
