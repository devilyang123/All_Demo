package com.xiao.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xiao.dao.IRegisterDao;
import com.xiao.pojo.User;

@Repository("registerDao")
public class RegisterDaoImpl implements IRegisterDao{
	
	private SessionFactory sf = null;
	
	@Resource(name = "sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	public void register(User user) throws Exception{
		
		sf.getCurrentSession().save(user);
	}
}
