package com.xiao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
/**
 * @author 笑笑
 * @Date   2018年3月15日下午2:38:39
 *	
 */
//通过加载properties文件来连接数据库的方式一
public class JDBCUtils_02 {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	/**
	 * 静态代码块加载配置文件信息
	 */
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");
	}
	//注册并获取数据库连接
	public static Connection getConnection() throws Exception{
		//1.注册驱动
		Class.forName(driver);
		//2.获取数据库连接
		Connection cn =  DriverManager.getConnection(url, username, password);
		return cn;
	}
	//释放资源
	public static void relase(Connection cn,Statement st,ResultSet rs) throws Exception{
		if(rs!=null){									    
			rs.close();
		}
		if(st!=null){
			st.close();
		}
		if(cn!=null){
			cn.close();
		}			
	}

}
