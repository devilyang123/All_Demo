package com.xiao.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * @author 笑笑
 * @Date   2018年3月15日上午10:55:16
 *	
 */
public class JDBCUtils_01 {
	//注册并获取数据库连接
	public static Connection getConnection() throws Exception{
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.声明数据库连接信息，获取数据库连接
		String url = "jdbc:mysql://localhost:3306/all_db";
		String username = "root";
		String password = "root";
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
