package com.xiao.controller;

import com.xiao.pojo.User;
import com.xiao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author 笑笑
 * @Date 16:32 2018/04/20
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    //注册请求映射地址
    @RequestMapping(value="/user/register")
    public String register(User user) throws Exception{
        userService.addUser(user);
        //重定向到查询用户列表的映射地址
        return "redirect:/user/getUserList";
    }

    //查询用户表列表
    @RequestMapping(value="/user/getUserList")
    public String getUserList(Model model) throws Exception{
        List<User> userList = userService.getUserList();
        //将用户列表放到域中
        model.addAttribute("userList", userList);
        return "list";
    }
    //用户列表的删除用户按钮
    @RequestMapping(value="/user/deleteUserByID")
    public String deleteUser(Integer id) throws Exception{
        userService.deleteUserByID(id);
        //重定向到查询用户列表的映射地址
        return "redirect:/user/getUserList";
    }
    //用户列表修改用户按钮
    @RequestMapping(value="/user/updateUser")
    public String updateUser(Integer id,Model model) throws Exception{
        User user = userService.getUserByID(id);
        //将user对象放到域中
        model.addAttribute("user", user);
        return "showUpdate";
    }
    //修改用户页面映射地址
    @RequestMapping(value="/user/toUpdateUser")
    public String toUpdateUser(User user) throws Exception{
        userService.updateUser(user);
        //重定向到查询用户列表的映射地址
        return "redirect:/user/getUserList";
    }

}
