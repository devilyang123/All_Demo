package com.xiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.xiao.mapper.UserMapper;
import com.xiao.pojo.User;
import com.xiao.service.UserService;

/**
 * @author 笑笑
 * @Date   2018年1月27日下午10:09:34  
 * 
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	//根据id查用户
	@Override
	public User findUserById(Integer uid) throws Exception {
		
		User user = userMapper.findUserById(uid);
		if(user != null){
			
			return user;
		}
		return null;
	}

	//注册用户
	@Override
	public void addUser(User user) throws Exception {
		
		userMapper.addUser(user);
		
	}
	//用户登录
	@Override
	public User findUserByUsernameAndPassword(User user) throws Exception {
		
		User u = userMapper.findUserByUsernameAndPassword(user);
		if(u !=null){
			return u;
		}
		return null;
	}
	//查询所有用户
	@Override
	public List<User> getUserList() throws Exception {
		
		List<User> userList = userMapper.getUserList();
		
		return userList;
	}
	//根据用户名查询用户
	@Override
	public User findUserByName(String username) throws Exception {
		
		User user = userMapper.findUserByName(username);
		if(user != null){
			return user;
		}
		return null;
	}

	@Override
	public List<User> getUserListByName(String username) throws Exception {
		
			List<User> userListByName = userMapper.getUserListByName(username);
			
			return userListByName;
	}

}
