package com.xiao.DButilsTest;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import com.xiao.utils.C3P0Utils;
/**
 * @author 笑笑
 * @Date   2018年3月16日下午2:41:56
 *	
 */
public class DButils_C3P0Pool {
	//添加数据,使用QueryRunner类的update方法
	@Test
	public void addUser() throws Exception{
		//创建QueryRunner类的对象,使用C3P0Utils获取连接池
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//书写SQL语句
		String sql = "insert into user_tb values(?,?,?,?,?,?)";
		//将？占位符的实际参数写在数组中
		Object[] params = {0,"笑笑","123456",23,"男","123@123.com"};
		//调用update执行SQL语句
		int row = qr.update(sql, params);
		if(row > 0){
			System.out.println("添加用户成功！");
		}else{
			System.out.println("添加用户失败！");
		}
		
	}

}
