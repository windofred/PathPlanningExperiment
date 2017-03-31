package cn.red.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.red.undirectional.Edge;
import cn.red.utils.JDBCTools;

public class EdgeDao {
	
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	
	//边集
	private static List<Edge> edgeList = null;
	
	//获取边的集合
	public static List<Edge> readEdgeInfo() throws Exception {
		//获取数据库的连接
		connection = JDBCTools.getConnection();
		String sql = "select * from edge";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		Edge edge = null;
		edgeList = new ArrayList<Edge>();
		
		while(resultSet.next()) {
			
			edge = new Edge();
			
			int edgeId = resultSet.getInt("edgeId");
			int startVertexId = resultSet.getInt("startVertexId");
			int endVertexId = resultSet.getInt("endVertexId");
			int weight = resultSet.getInt("weight");
			double density = resultSet.getDouble("density");
			
			edge.setId(edgeId);
			edge.setStartVertexId(startVertexId);
			edge.setEndVertexId(endVertexId);
			edge.setWeight(weight);
			edge.setDensity(density);
			
			edgeList.add(edge);
		}
		
		//关闭数据库连接资源
		//JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		
		return edgeList;
	}
	
}
