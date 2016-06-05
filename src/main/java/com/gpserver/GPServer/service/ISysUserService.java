package com.gpserver.GPServer.service;

import java.util.List;

import com.gpserver.GPServer.entity.SysUser;

public interface ISysUserService {

	public void saveWithJDBC(String uName, int uage);
	public SysUser selectAllByIdWithJDBC(int uage);
	public List<SysUser> selectAllWithJDBC();
	public void deleteByIdWithJDBC(int uId);
	
	public void saveWithMybatis(String uName, int uage);
	public SysUser selectAllByIdWithMybatis(int uage);
	public List<SysUser> selectAllWithMybatis();
	public void deleteByIdWithMybatis(int uId);
}
