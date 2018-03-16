package com.xiao.DButilsTest;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import com.xiao.pojo.User;
import com.xiao.utils.JDBCUtils_03;
/**
 * @author 笑笑
 * @Date   2018年3月16日上午11:54:46
 *	
 */
public class QueryRunnerDemo {
	
	//添加数据,使用QueryRunner类的update方法
	@Test
	public void addUser() throws Exception{
		//JDBCUtils_03工具类获取数据库连接
		Connection cn = JDBCUtils_03.getConnection();
		//创建QueryRunner类的对象
		QueryRunner qr = new QueryRunner();
		//书写SQL语句
		String sql = "insert into user_tb values(?,?,?,?,?,?)";
		//将？占位符的实际参数写在数组中
		Object[] params = {0,"笑笑","123456",23,"男","123@123.com"};
		//调用update执行SQL语句
		int row = qr.update(cn, sql, params);
		if(row > 0){
			System.out.println("添加用户成功！");
		}else{
			System.out.println("添加用户失败！");
		}
		//释放资源
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//修改数据
	@Test
	public void updateUser() throws Exception{
		//JDBCUtils_03工具类获取数据库连接
		Connection cn = JDBCUtils_03.getConnection();
		//创建QueryRunner类的对象
		QueryRunner qr = new QueryRunner();
		//书写SQL语句
		String sql = "update user_tb set username = ? where uid = ?";
		//定义参数数组
		Object[] params = {"我爱笑笑",1};
		//执行SQL语句
		int row = qr.update(cn, sql, params);
		if(row > 0){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败！");
		}
		//释放资源
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//删除数据
	@Test
	public void removeUser() throws Exception{
		//JDBCUtils_03工具类获取数据库连接
		Connection cn = JDBCUtils_03.getConnection();
		//创建QueryRunner类的对象
		QueryRunner qr = new QueryRunner();
		//书写SQL语句
		String sql = "delete from user_tb where uid = ?";
		//只有一个参数，可以直接调用update方法执行
		int row = qr.update(cn, sql, 1);
		if(row > 0){
			System.out.println("删除成功！");
		}else{
			System.out.println("删除失败！");
		}
		//释放资源
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//查询数据，使用QueryRunner类的query方法
	//ArrayHandler,将结果集的第一条数据存储到一个对象数组中,数组中的每个值对应此条数据的每个字段值
	@Test
	public void arrayHandler() throws Exception{
		//JDBCUtils_03工具类获取数据库连接
		Connection cn = JDBCUtils_03.getConnection();
		//创建QueryRunner类的对象
		QueryRunner qr = new QueryRunner();
		//书写SQL语句
		String sql = "select * from user_tb";
		//调用query方法执行查询
		Object[] result = qr.query(cn, sql, new ArrayHandler());
		//增强for遍历数组
		for (Object object : result) {
			System.out.print(object+"\t");
		}
		//释放资源
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//ArrayListHandler,将结果集的每一条数据存储到对象数组中，将对象数组存储到List集合中
	@Test
	public void arrayListHandler() throws Exception{
		//JDBCUtils_03工具类获取数据库连接
		Connection cn = JDBCUtils_03.getConnection();
		//创建QueryRunner类的对象
		QueryRunner qr = new QueryRunner();
		//书写SQL语句
		String sql = "select * from user_tb";
		//调用query方法执行查询
		List<Object[]> result = qr.query(cn, sql, new ArrayListHandler());
		//增强for遍历数组,外层循环遍历集合，内层循环遍历数组
		for (Object[] objects : result) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		//释放资源
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//BeanHandler,将结果集的第一条数据封装成JavaBean对象，被封装的对象必须要有空参构造
	@Test
	public void beanHandler()throws Exception{
		//JDBCUtils_03工具类获取数据库连接
		Connection cn = JDBCUtils_03.getConnection();
		//创建QueryRunner类的对象
		QueryRunner qr = new QueryRunner();
		//书写SQL语句
		String sql = "select * from user_tb where uid = ?";
		//执行SQL语句,结果集的第一条数据封装到User对象
		User user = qr.query(cn, sql, new BeanHandler<>(User.class),12);
		System.out.println(user);
		//释放资源
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//BeanListHandler,将结果集的每一条数据封装成JavaBean对象 ，将JavaBean对象放入List集合中
	@Test
	public void beanListHandler()throws Exception{
		//JDBCUtils_03工具类获取数据库连接
		Connection cn = JDBCUtils_03.getConnection();
		//创建QueryRunner类的对象
		QueryRunner qr = new QueryRunner();
		//书写SQL语句
		String sql = "select * from user_tb";
		//执行SQL语句,结果集的每一条数据封装到User对象
		List<User> list = qr.query(cn, sql, new BeanListHandler<>(User.class));
		//增强for遍历集合
		for (User user : list) {
			System.out.println(user);
		}
		//释放资源
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//ColumnListHandler,将结果集中指定的列的字段值，封装到List集合中
	@Test
	public void columnListHandler() throws Exception{
		//JDBCUtils_03工具类获取数据库连接
		Connection cn = JDBCUtils_03.getConnection();
		//创建QueryRunner类的对象
		QueryRunner qr = new QueryRunner();
		//书写SQL语句
		String sql = "select * from user_tb";
		//执行SQL语句,用列名做参数
		List<Object> list = qr.query(cn, sql, new ColumnListHandler<>("username"));
		//遍历集合
		for (Object object : list) {
			System.out.println(object);
		}
		//释放资源
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//ScalarHandler,用于只有一个数据结果的，如聚合函数：count
	@Test
	public void scalarHandler()throws Exception{
		//JDBCUtils_03工具类获取数据库连接
		Connection cn = JDBCUtils_03.getConnection();
		//创建QueryRunner类的对象
		QueryRunner qr = new QueryRunner();
		//书写SQL语句
		String sql = "select count(*) from user_tb";
		//执行SQL语句
		long count = qr.query(cn, sql, new ScalarHandler<Long>());
		System.out.println(count);
		//释放资源
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//MapHandler,将结果集的第一条数据封装到Map集合
	@Test
	public void mapHandler()throws Exception{
		//JDBCUtils_03工具类获取数据库连接
		Connection cn = JDBCUtils_03.getConnection();
		//创建QueryRunner类的对象
		QueryRunner qr = new QueryRunner();
		//书写SQL语句
		String sql = "select * from user_tb";
		//执行SQL语句
		Map<String, Object> map = qr.query(cn, sql, new MapHandler());
		//遍历Map集合
		for(String key:map.keySet()){
			System.out.println(key+"  "+map.get(key));
		}
		//释放资源
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//MapListHandler,将结果集的每一条数据封装到Map集合中，再将Map集合放入List集合中
	@Test
	public void mapListHandler()throws Exception{
		//JDBCUtils_03工具类获取数据库连接
		Connection cn = JDBCUtils_03.getConnection();
		//创建QueryRunner类的对象
		QueryRunner qr = new QueryRunner();
		//书写SQL语句
		String sql = "select * from user_tb";
		//执行SQL语句
		List<Map<String,Object>> list = qr.query(cn, sql, new MapListHandler());
		//遍历，外层循环遍历List集合，内层循环遍历Map集合
		for(Map<String,Object>map:list){
			for(String key:map.keySet()){
				System.out.println(key+"  "+map.get(key));
			}
			System.out.println();
		}
		//释放资源
		JDBCUtils_03.relase(cn, null, null);
	}
}
