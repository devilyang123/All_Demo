package com.xiao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;
import com.xiao.utils.JDBCUtils_02;
import com.xiao.utils.JDBCUtils_03;
/**
 * @author 笑笑
 * @Date   2018年3月15日下午2:42:15
 *	
 */
//通过加载properties文件来连接数据库的两种方式测试
public class JDBC_03 {
	//通过加载properties文件来连接数据库的方式一  测试
	@Test
	public void test_01() throws Exception{
		//1.使用工具类JDBCUtils_02注册并获取连接
		Connection cn = JDBCUtils_02.getConnection();
		//2.书写SQL语句
		String sql = "select * from user_tb";
		//3.获取SQL语句预编译对象
		PreparedStatement ps = cn.prepareStatement(sql);
		//4.执行SQL语句
		ResultSet rs = ps.executeQuery();
		//5.处理结果集
		while(rs.next()){
			System.out.println(rs.getInt("uid")+"  "+rs.getString("username"));
		}
		//6.释放资源
		JDBCUtils_02.relase(cn, ps, rs);
	}
	//通过加载properties文件来连接数据库的方式二  测试
	@Test
	public void test_02() throws Exception{
		//1.使用工具类JDBCUtils_03注册并获取连接
		Connection cn = JDBCUtils_03.getConnection();
		//2.书写SQL语句
		String sql = "select * from user_tb";
		//3.获取SQL语句预编译对象
		PreparedStatement ps = cn.prepareStatement(sql);
		//4.执行SQL语句
		ResultSet rs = ps.executeQuery();
		//5.处理结果集
		while(rs.next()){
			System.out.println(rs.getInt("uid")+"  "+rs.getString("username"));
		}
		//6.释放资源
		JDBCUtils_02.relase(cn, ps, rs);
	}
}
