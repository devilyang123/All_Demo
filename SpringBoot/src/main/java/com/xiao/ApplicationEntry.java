package com.xiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Author 笑笑
 * @Date 16:31 2018/04/20
 */
//扫描同级包下
@SpringBootApplication
//@ComponentScan(basePackages = "com.xiao")
@MapperScan(basePackages = "com.xiao.mapper")
//@EnableAutoConfiguration
public class ApplicationEntry {

    public static void main(String[] args){
        SpringApplication.run(ApplicationEntry.class,args);
    }


}


