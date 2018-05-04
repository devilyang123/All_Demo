package com.xiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 笑笑
 * @Date 19:31 2018/05/03
 */
@SpringBootApplication
@MapperScan(basePackages = "com.xiao.mapper")
public class ApplicationEntry {

    public static void main(String[] args){
        SpringApplication.run(ApplicationEntry.class,args);
    }
}
