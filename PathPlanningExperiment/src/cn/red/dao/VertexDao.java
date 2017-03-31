package cn.red.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cn.red.undirectional.Vertex;
import cn.red.utils.JDBCTools;

public class VertexDao {
	
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	//节点集合
	private static List<Vertex> vertexList = null;
	//返回节点集合
	public static List<Vertex> readVertexInfo() throws Exception {
		// 获取数据库的连接
		connection = JDBCTools.getConnection();
		// 查询节点表
		String sql = "select * from vertex";
		preparedStatement = connection.prepareStatement(sql);
		// 获取结果集
		resultSet = preparedStatement.executeQuery();
		
		Vertex vertex = null;
		vertexList = new ArrayList<Vertex>();
		
		while(resultSet.next()) {
			
			vertex = new Vertex();
			
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			
			vertex.setId(id);
			vertex.setName(name);
			
			vertexList.add(vertex);
			
		}
		
		//关闭资源
		JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		
		return vertexList;
		
	}

}
