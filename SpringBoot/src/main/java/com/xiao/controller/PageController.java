package com.xiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
	
	@RequestMapping("/")
	public String showRegister(){
		
		return "register";
	}

	//页面跳转，请求哪个页面，跳转哪个页面
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page)throws Exception{
		
		return page;
	}

}
