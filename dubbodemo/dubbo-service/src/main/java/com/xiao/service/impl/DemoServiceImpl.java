package com.xiao.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiao.service.DemoService;

/**
 * @Description 服务提供方接口 实现类
 * @Auther: 笑笑
 * @Date: 15:19 2018/9/14
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String hello() {
        return "Hello Dubbo!";
    }
}
