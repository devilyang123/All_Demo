package com.xiao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.xiao.pojo.User;
import com.xiao.utils.JDBCUtils_01;
/**
 * @author 笑笑
 * @Date   2018年3月15日下午1:15:20
 *	
 */
public class JDBC_02 {
	
	//把结果集封装到对象
	@Test
	public void test() throws Exception{
		//注册并获取连接
		Connection cn = JDBCUtils_01.getConnection();
		//书写SQL语句
		String sql = "select * from user_tb";
		//获取SQL语句预编译对象
		PreparedStatement ps = cn.prepareStatement(sql);
		//执行SQL语句
		ResultSet rs = ps.executeQuery();
		//创建对象集合
		List<User> list = new ArrayList<>();
		//处理结果集
		while(rs.next()){
			/*方式一:获取到的每列数据，使用setXXX()方法手动封装到User对象中
			User u = new User();
			u.setUid(rs.getInt("uid"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setAge(rs.getInt("age"));
			u.setGender(rs.getString("gender"));
			u.setEmail(rs.getString("email"));*/
			//方式二：用有参构造器封装
			User u = new User(
							  rs.getInt("uid"),rs.getString("username"),
					          rs.getString("password"),rs.getInt("age"),
					          rs.getString("gender"),rs.getString("email")
							);
			//将封装的对象放入到集合中
			list.add(u);
		}
		//增强for遍历对象集合
		for (User user : list) {
			System.out.println(user);
		}
		//释放资源
		JDBCUtils_01.relase(cn, ps, rs);
	}
	
}
