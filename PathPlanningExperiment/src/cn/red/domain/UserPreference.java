package cn.red.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.red.utils.JDBCTools;

public class UserPreference {

	private static final int K = 3;
	
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	static List<Preference> preferencesList = null;
	
	//最终需要返回的前N个偏好点的集合
	static List<Preference> mostPreferenceList = null;

	// 根据用户的历史记录为用户推荐前N个偏好点
	public static List<Preference> recommandPreferences() throws Exception {
		
		// 获取数据库的连接
		connection = JDBCTools.getConnection();
		// 按(grade+retention)和的降序排序
		String sql = "select * from preference where user_id=1 order by grade+retention desc";
		preparedStatement = connection.prepareStatement(sql);
		// 获取结果集
		resultSet = preparedStatement.executeQuery();

		Preference Preference = null;
		preferencesList = new ArrayList<Preference>();// 初始化
		mostPreferenceList = new ArrayList<Preference>();//初始化
		// 遍历结果集
		while (resultSet.next()) {

			Preference = new Preference();

			int id = resultSet.getInt("id");
			int userId = resultSet.getInt("user_id");
			int vertexId = resultSet.getInt("vertex_id");
			float grade = resultSet.getFloat("grade");
			int retention = resultSet.getInt("retention");

			Preference.setId(id);
			Preference.setUserId(userId);
			Preference.setVertexId(vertexId);
			Preference.setGrade(grade);
			Preference.setRetention(retention);

			preferencesList.add(Preference);

			/*
			 * System.out.println("用户id: " + userId + " 节点id: " + vertexId +
			 * " 评分：" + grade + " 停留时间：" + retention);
			 */
		}

		// 遍历PreferencesList
//		for (Preference u : preferencesList) {
//			System.out.println(u);
//		}
		
		System.out.println();
		
		//将所有偏好点集合中前K个偏好点返回给用户，并作为其最偏好的特征点
		for(int i=0; i<K; i++) {
			mostPreferenceList.add(preferencesList.get(i));
		}
		
		System.out.println("用户偏好点：");
		//遍历mostPreferenceList
		for(Preference p : mostPreferenceList) {
			System.out.println(p);
		}
		
		// 打印PreferencesList的大小
		// System.out.println(PreferencesList.size());

		// 获得用户的评分和用户的停留时间
//		int grade_length = preferencesList.size();
//		float[] grades = new float[grade_length];
//		int[] retentions = new int[grade_length];
//
//		for (int i = 0; i < grade_length; i++) {
//			grades[i] = preferencesList.get(i).getGrade();
//			retentions[i] = preferencesList.get(i).getRetention();
//		}

		JDBCTools.releaseDB(resultSet, preparedStatement, connection);
	
		return mostPreferenceList;
		
	}

}
