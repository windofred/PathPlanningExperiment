package cn.red.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VertexDaoImpl implements VertexDao {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	//用于存放顶点数据
	ArrayList<String> list = new ArrayList<String>();
	
	@Override
	public List<String> findVertexInfo() {
		
		try {
			//获得数据库连接
			connection = JDBCTools.getConnection();
			//sql语句
			String sql = "select * from vdata";
			//获得操作数据库的对象
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String data = resultSet.getString("data");
				list.add(data);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
		
		return list;
		
	}

}
