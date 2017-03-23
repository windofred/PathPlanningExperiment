package cn.red.utils;

import org.junit.Test;

public class JDBCToolsTest {
	
	//测试数据库是否连接成功
	@Test
	public void testConnection() throws Exception {
		//测试数据库连接成功
		System.out.println(JDBCTools.getConnection());
	}
	
}
