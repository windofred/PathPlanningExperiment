package cn.red.utils;

import org.junit.Test;

public class JDBCToolsTest {
	
	//测试数据库是否连接成功
	@Test
	public void testConnection() throws Exception {
		System.out.println(JDBCTools.getConnection());
	}
	
}
