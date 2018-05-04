package com.xiao.mapper;

import java.util.List;
import com.xiao.pojo.User;

public interface UserMapper {

	//添加用户
	void  addUser(User user) throws  Exception;

	//查询用户列表
	 List<User> getUserList() throws Exception;

	//根据id删除用户
	 void deleteUserByID(Integer id) throws Exception;

	//根据id查询用户，用于修改时的数据回显
	User getUserByID(Integer id) throws  Exception;

	//修改用户
	 void updateUser(User user) throws Exception;

}
