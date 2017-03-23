package cn.red.domain;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.red.utils.JDBCTools;


public class UserTest {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	List<UserPreference> userPreferencesList = null;
	
	@Test
	public void test1() {
		try {
			//获取数据库的连接
			connection = JDBCTools.getConnection();
			String sql = "select * from preference order by grade+retention desc";
			preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setInt(1, 3);
			//获取结果集
			resultSet = preparedStatement.executeQuery();
			
			UserPreference userPreference = null;
			userPreferencesList = new ArrayList<UserPreference>();//初始化
			
			while(resultSet.next()) {
				
				userPreference = new UserPreference();
				
				int id = resultSet.getInt("id");
				String userId = resultSet.getString("user_id");
				String vertexId = resultSet.getString("vertex_id");
				float grade = resultSet.getFloat("grade");
				int retention = resultSet.getInt("retention");
				
				userPreference.setId(id);
				userPreference.setUserId(userId);
				userPreference.setVertexId(vertexId);
				userPreference.setGrade(grade);
				userPreference.setRetention(retention);
				
				userPreferencesList.add(userPreference);
				
				/*System.out.println("用户id: " + userId + " 节点id: " + vertexId + " 评分：" 
									+ grade + " 停留时间：" + retention);*/
			}
			
			//遍历userPreferencesList
			for(UserPreference u : userPreferencesList) {
				System.out.println(u);
			}
			
			//获得用户的评分和用户的停留时间
			int grade_length = userPreferencesList.size();
			float[] grades = new float[grade_length];
			int[] retentions = new int[grade_length];
			
			for(int i=0; i<grade_length; i++) {
				grades[i] = userPreferencesList.get(i).getGrade();
				retentions[i] = userPreferencesList.get(i).getRetention();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
		
	}
	
}
