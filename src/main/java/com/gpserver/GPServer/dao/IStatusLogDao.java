package com.gpserver.GPServer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gpserver.GPServer.entity.StatusLog;

@Repository
public interface IStatusLogDao {

	List<StatusLog> selectStatusLogList();

}
