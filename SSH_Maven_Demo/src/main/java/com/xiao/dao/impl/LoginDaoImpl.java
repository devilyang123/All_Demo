package com.xiao.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xiao.dao.ILoginDao;
import com.xiao.pojo.User;

@Repository("loginDao")
public class LoginDaoImpl implements ILoginDao {
	
	private SessionFactory sf = null;
	
	@Resource(name = "sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public User findUserByUnameAndPassword(String uname , String password) throws Exception {
		
		Session session = sf.getCurrentSession();
		String hql = "from User u where u.uname =? and u.password = ?";
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>)session.createQuery(hql).setParameter(0, uname).setParameter(1, password).list();
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	

	

}
