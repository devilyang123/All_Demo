package com.xiao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

import com.xiao.utils.JDBCUtils_01;
/**
 * @author 笑笑
 * @Date   2018年3月15日上午9:24:53
 *	
 */
public class JDBC_01 {
	/*
	 * JDBC开发步骤:
	 * 	1.注册驱动
	 * 	2.获得数据库连接
	 *  3.获得执行SQL语句的对象
	 *  4.书写SQL语句
	 *  5.执行SQL语句
	 *  6.处理结果
	 *  7.释放资源
	 * 
	 */
	//插入数据
	@Test
	public void insert() throws Exception{
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.声明数据库连接信息，获取数据库连接
		String url = "jdbc:mysql://localhost:3306/all_db";
		String username = "root";
		String password = "root";
		Connection cn = DriverManager.getConnection(url, username, password);
		//3.创建执行SQL语句的对象
		Statement st = cn.createStatement();
		//4.书写SQL语句(如果表的主键自增，插入数据时，主键写0即可)
		String sql = "insert into user_tb values(0,'笑笑','123456',23,'男','123@123.com')";
		//5.执行sql语句
		int row = st.executeUpdate(sql);
		//6.处理结果 ,插入数据操作,返回受影响的行数
		System.out.println(row);
		//7.释放资源(先得到的后释放)
		if(st!=null){
			st.close();
		}
		if(cn!=null){
			cn.close();
		}			
	}
	
	//查询数据
	@Test
	public void select() throws Exception{
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.声明数据库连接信息，获取数据库连接
		String url = "jdbc:mysql://localhost:3306/all_db";
		String username = "root";
		String password = "root";
		Connection cn = DriverManager.getConnection(url, username, password);
		//3.创建执行SQL语句的对象
		Statement st = cn.createStatement();
		//4.书写SQL语句
		String sql = "select * from user_tb";
		//5.执行sql语句,获取结果集
		ResultSet rs = st.executeQuery(sql);
		//6.处理结果集rs,使用next()方法来遍历结果集
		while(rs.next()){
			//方式一:rs.getXXX(index)表示获取index列的XXX类型数据,列的索引从1开始
			//rs.getInt(1);表示获取第一列的数据，再加上循环遍历，就可以得到第一列所有的数据
			//方式二:rs.getXXX(列名)表示通过一个字符串的列名来获取XXX类型的数据
			System.out.println(rs.getInt("uid")+"  "+rs.getString("username"));
		}
		//7.释放资源(先得到的后释放)
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
	
	//自定义JDBC工具类测试
	@Test
	public void testJDBCUtils() throws Exception{
		//1.使用工具类注册并获取数据库连接
		Connection cn = JDBCUtils_01.getConnection();
		//2.创建执行SQL语句对象
		Statement st = cn.createStatement();
		//3.书写SQL语句
		String sql = "select * from user_tb";
		//4.执行SQL语句
		ResultSet rs = st.executeQuery(sql);
		//5.处理结果集
		while(rs.next()){
			System.out.println(rs.getInt("uid")+"  "+rs.getString("username"));
		}
		//6.释放资源
		JDBCUtils_01.relase(cn, st, rs);
	}
	
	//使用PrepareStatement接口预编译SQL语句，防止SQL注入攻击,提高执行的效率
	@Test
	public void testPrepareStatement() throws Exception{
		//1.使用工具类注册并获取数据库连接
		Connection cn = JDBCUtils_01.getConnection();
		//2.书写SQL语句
		String sql = "select * from user_tb where username = ?";
		//3.获取SQL语句预编译对象，PreparedStatement是Statement的子接口
		PreparedStatement ps = cn.prepareStatement(sql);
		//4.设置？占位符的值,第一个参数代表的是第几个？号占位符，索引从1开始
		ps.setString(1, "笑笑");	
		//5.执行SQL语句
		ResultSet rs = ps.executeQuery();	
		//6.处理结果集
		while(rs.next()){														
			System.out.println(rs.getInt("uid")+"  "+rs.getString("username"));
		}
		//7.释放资源
		JDBCUtils_01.relase(cn, ps, rs);										
	}
}
