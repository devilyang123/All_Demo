package com.xiao.service;

import java.util.List;

import com.xiao.pojo.User;

/**
 * @author 笑笑
 * @Date   2018年1月27日下午9:42:13  
 * 
 */
public interface UserService {
	
	
	//添加用户
	public void addUser(User user) throws Exception;
	
	//查询所有用户
	public List<User> getUserList() throws Exception;
	
	//根据用户名查询用户
	public User	findUserByName(String username) throws Exception;
	
	//根据用户名模糊查询用户
	public List<User> getUserListByName(String username) throws Exception;
	
	//用户登录
	public User findUserByUsernameAndPassword(User user) throws Exception;
	
	//通过主键uid查询用户
	public User findUserById(Integer uid) throws Exception;

}
