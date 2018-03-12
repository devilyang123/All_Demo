package com.xiao.service.impl;

import javax.annotation.Resource;




import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiao.dao.IRegisterDao;
import com.xiao.pojo.User;
import com.xiao.service.IRegisterService;


@Service("registerService")
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
//@Transactional
public class RegisterServiceImpl implements IRegisterService {
	
	private IRegisterDao dao;

	@Resource(name = "registerDao")
	public void setDao(IRegisterDao dao) {
		this.dao = dao;
	}

	@Override
	public void register(User user) {
		
		try {
			dao.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
