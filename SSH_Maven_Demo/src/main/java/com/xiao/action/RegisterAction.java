package com.xiao.action;


import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiao.pojo.User;
import com.xiao.service.IRegisterService;

@Controller("RegisterAction")
@Scope("prototype")
@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	
	private User user = new User();
	
	private IRegisterService rs;
	
	@Resource(name = "registerService")
	public void setRs(IRegisterService rs) {
		this.rs = rs;
	}


	public String register(){
		
		try {
			rs.register(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "registerFail";
		}
		
		
	}
	
	
	@Override
	public User getModel() {
		return user;
	}
	
	
}
