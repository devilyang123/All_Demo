package com.xiao.controller;

import com.xiao.mapper.UserMapper;
import com.xiao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**0
 * @Author 笑笑
 * @Date 19:38 2018/05/03
 */
@RestController
public class UserController {

    //直接注入mapper
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/getUser")
    public User getUser(Integer id) throws  Exception{

        User user = userMapper.getUser(id);
        return user;
    }

}
