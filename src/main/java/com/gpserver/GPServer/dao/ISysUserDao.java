package com.gpserver.GPServer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gpserver.GPServer.entity.SysUser;

@Repository
public interface ISysUserDao {

	public void save(SysUser user);
	public SysUser selectById(int id);
	public void deleteById(int id);
	public List<SysUser> selectAll();
}
