package com.xiao.action;


import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiao.pojo.User;
import com.xiao.service.ILoginService;

@Controller("loginAction")
@Scope("prototype")
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	private ILoginService ls;
	
	@Resource(name="loginService")
	public void setLs(ILoginService ls) {
		this.ls = ls;
	}


	public String login(){
		try {
			User u = ls.login(user);
			if(u!=null){
				ServletActionContext.getRequest().getSession().setAttribute("user", u);
				return "home";
			}else{
				ServletActionContext.getRequest().setAttribute("fail", "用户名或密码错误");
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			ServletActionContext.getRequest().setAttribute("fail", "登录失败");
			return "login";
		}
		
	}
	
	@Override
	public User getModel() {
		return user;
	}

}
