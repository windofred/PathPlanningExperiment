package cn.red.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTools {
	
	public static Connection getConnection() throws Exception {
		Properties properties = new Properties();
		InputStream inStream = JDBCTools.class.getClassLoader().getResourceAsStream("db.properties");
		properties.load(inStream);

		// 1.准备获取连接的 4 个字符串: user, password, jdbcUrl, driverClass
		String user = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");
		String jdbcUrl = properties.getProperty("jdbc.url");
		String driverClass = properties.getProperty("jdbc.driver");

		// 2.加载驱动: Class.forName(driverClass)
		Class.forName(driverClass);

		// 3.调用
		// DriverManager.getConnection(jdbcUrl, user, password)
		// 获取数据库连接
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		return connection;
	}

	//释放资源
	public static void releaseDB(ResultSet resultSet, Statement statement, Connection connection) {

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
