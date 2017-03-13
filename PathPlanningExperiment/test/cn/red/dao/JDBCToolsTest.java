package cn.red.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class JDBCToolsTest {

	@Test
	public void testGetConnection() throws Exception {
		
		Connection connection = JDBCTools.getConnection();
		System.out.println(connection);
		
	}

}
