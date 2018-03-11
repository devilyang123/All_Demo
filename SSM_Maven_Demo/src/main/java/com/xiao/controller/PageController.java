package com.xiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xiao.service.UserService;

/**
 * @author 笑笑
 * @Date   2018年1月27日下午9:19:54  
 * 
 */
@Controller
public class PageController {
	
	@Autowired
	private UserService  userService;
	
	//默认跳转首页
	@RequestMapping("/")
	public String showIndex() throws Exception{
		/*List<User> userList = userService.getUserList();
		model.addAttribute("userList", userList);*/
		return "index";
	}
	//请求什么页面，跳转什么页面
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		
		return page;
	}

}
