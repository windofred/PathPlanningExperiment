package cn.red.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EdgeDaoImpl implements EdgeDao {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	//查找边的信息
	@Override
	public void findEdgeInfo() {
		try {
			// 获得数据库连接
			connection = JDBCTools.getConnection();
			// sql语句
			String sql = "select * from edata";
			// 获得操作数据库的对象
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String start = resultSet.getString("start");
				String end = resultSet.getString("end");
				int weight = resultSet.getInt("weight");
				// mVexs[i++] = data;
				// System.out.println(data);
				System.out.println(start + "->" + end + "->" + weight);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
	}

}
