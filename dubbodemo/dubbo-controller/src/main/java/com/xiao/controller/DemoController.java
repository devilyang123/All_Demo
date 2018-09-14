package com.xiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiao.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 服务消费方
 * @Auther: 笑笑
 * @Date: 15:35 2018/9/14
 */
@Controller
public class DemoController {

    @Reference
    private DemoService service;

    @RequestMapping(value = "/dubbo/demo")
    @ResponseBody
    public String hello(){
        return service.hello();
    }
}
