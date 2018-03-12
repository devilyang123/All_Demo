package com.xiao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiao.dao.ILoginDao;
import com.xiao.pojo.User;
import com.xiao.service.ILoginService;

@Service("loginService")
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
public class LoginServiceImpl implements ILoginService {
	
	private ILoginDao dao;
	
	@Resource(name = "loginDao")
	public void setDao(ILoginDao dao) {
		this.dao = dao;
	}

	@Override
	public User login(User user) throws Exception {
		
		
		User u = dao.findUserByUnameAndPassword(user.getUname(),user.getPassword());
		
		return u;
	}

}
