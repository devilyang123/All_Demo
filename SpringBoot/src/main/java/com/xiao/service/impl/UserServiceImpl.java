package com.xiao.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiao.mapper.UserMapper;
import com.xiao.pojo.User;
import com.xiao.service.IUserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

	//注入mapper
	@Autowired
	private UserMapper userMapper;
	
	//添加用户
	@Transactional
	@Override
	public void addUser(User user) throws Exception {
			userMapper.addUser(user);
	}
	//查询用户列表
	@Override
	public List<User> getUserList() throws Exception {
		List<User> userList = userMapper.getUserList();
		if(userList != null){
			return userList;
		}
		return null;
	}
	//根据id删除用户
	@Override
	public void deleteUserByID(Integer id) throws Exception {
		userMapper.deleteUserByID(id);
	}
	//根据id查询用户，用于修改时的数据回显
	@Override
	public User getUserByID(Integer id) throws Exception {
		User user = userMapper.getUserByID(id);
		if(user != null){
			return user;
		}
		return null;
	}
	//修改用户
	@Override
	public void updateUser(User user) throws Exception {
			userMapper.updateUser(user);
	}

}
