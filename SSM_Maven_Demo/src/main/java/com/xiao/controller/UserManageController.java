package com.xiao.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiao.pojo.User;
import com.xiao.service.UserService;

/**
 * @author 笑笑
 * @Date   2018年1月27日下午10:11:12  
 * 
 */
@Controller
public class UserManageController {
	
	@Autowired
	private UserService userService;
	
	//根据id查找用户，返回Json格式数据
	@RequestMapping("/findUser_{uid}")
	@ResponseBody
	public User getUserById(@PathVariable Integer uid) throws Exception{
		
		User user = userService.findUserById(uid);
		
		return user;
	}
	//用户注册
	@RequestMapping("/user/register")
	public String register(User user) throws Exception{
		
		userService.addUser(user);
		
		return "success";
	}
	//用户登录
	@RequestMapping("/user/login")
	public String login(User user,Model model) throws Exception{
		
		User u = userService.findUserByUsernameAndPassword(user);
		if(u !=null){
			String a = u.getUsername();
			model.addAttribute("user",a);
			return "success";
		}else{
			String error = "用户名或密码错误";
			model.addAttribute("user",error);
			return "login";
		}
		
	}
	//用户名校验
	@RequestMapping(value = "/checkUsername",method = RequestMethod.POST)
	@ResponseBody
	public User checkUsername(String username) throws Exception{
		
		User user = userService.findUserByName(username);
		return user;
	}
	//根据用户名模糊查询用户
	@RequestMapping("/searchUser")
	@ResponseBody
	public List<User> findUserByName(String username) throws Exception{
		
		List<User> userListByName = userService.getUserListByName(username);
		
		return userListByName;
	}

}
