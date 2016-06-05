package com.gpserver.GPServer.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gpserver.GPServer.entity.SysUser;
import com.gpserver.GPServer.service.ISysUserService;

@Controller
public class SysUserController {

	@Resource
	ISysUserService service;
	
	@RequestMapping("/jdbc/all")
	public void selecAll() {
		List<SysUser> userList = service.selectAllWithJDBC();
		for (SysUser sysUser : userList) {
			System.out.println(sysUser.toString());
		}
	}
	@RequestMapping("/jdbc/select/{id}")
	public void selecAll(@PathVariable Integer id) {
		SysUser user = service.selectAllByIdWithJDBC(id);
		if(user != null) {
			System.out.println(user.toString());
		} else {
			System.out.println("not fount");
		}
	}
	@RequestMapping("/jdbc/delete/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteByIdWithJDBC(id);
		System.out.println("jdbc delete success");
	}
	@RequestMapping("/jdbc/save")
	public void save(@RequestParam String uName, @RequestParam Integer uAge) {
		service.saveWithJDBC(uName, uAge);;
		System.out.println("jdbc save success");
	}
	
	//--------------------
	
	@RequestMapping("/mybatis/all")
	public void mybatisselecAll() {
		List<SysUser> userList = service.selectAllWithMybatis();
		for (SysUser sysUser : userList) {
			System.out.println(sysUser.toString());
		}
	}
	@RequestMapping("/mybatis/select/{id}")
	public void mybatisselecAll(@PathVariable Integer id) {
		SysUser user = service.selectAllByIdWithMybatis(id);
		if(user != null) {
			System.out.println(user.toString());
		} else {
			System.out.println("not fount");
		}
	}
	@RequestMapping("/mybatis/delete/{id}")
	public void mybatisdelete(@PathVariable Integer id) {
		service.deleteByIdWithMybatis(id);;
		System.out.println("jdbc delete success");
	}
	@RequestMapping("/mybatis/save}")
	public void mybatissave(@RequestParam String uName, @RequestParam Integer uAge) {
		service.saveWithMybatis(uName, uAge);
		System.out.println("jdbc save success");
	}
}
