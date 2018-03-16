package com.xiao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
/**
 * @author 笑笑
 * @Date   2018年3月15日下午2:38:39
 *	
 */
//通过加载properties文件来连接数据库的方式二
public class JDBCUtils_03 {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	/**
	 * 静态代码块加载配置文件信息
	 */
	static {
		try {
			// 1.通过当前类获取类加载器
			ClassLoader classLoader = JDBCUtils_03.class.getClassLoader();
			// 2.通过类加载器的方法获得一个输入流
			InputStream in = classLoader.getResourceAsStream("jdbc.properties");
			// 3.创建一个properties对象(集合)
			Properties props = new Properties();
			// 4.加载输入流
			props.load(in);
			// 5.获取相关参数的值
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

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
