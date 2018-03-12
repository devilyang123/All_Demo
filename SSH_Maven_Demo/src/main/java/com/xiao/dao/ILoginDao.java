package com.xiao.dao;

import com.xiao.pojo.User;

public interface ILoginDao {
	

	public User findUserByUnameAndPassword(String uname ,String password) throws Exception ;

}
