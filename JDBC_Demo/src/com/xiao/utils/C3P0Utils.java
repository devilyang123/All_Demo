package com.xiao.utils;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	//加载默认配置文件目录：src/c3p0-config.xml
	public static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//获取连接池
	public static DataSource getDataSource(){
		return dataSource;
	}
	
}
