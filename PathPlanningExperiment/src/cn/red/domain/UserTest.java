package cn.red.domain;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.red.undirectional.Vertex;

public class UserTest {
	
	@Test
	public void test1() {
		
		//Map<User,Vertex> map = new HashMap<User,Vertex>();
		
		Map<User, Map<Vertex,Integer>> map = new HashMap<User, Map<Vertex,Integer>>();

		//用户1
		User user1 = new User();
		user1.setId("1");
		user1.setName("Jack");
	
		//用户1分别对特征点1,2,3的评分
		float[] user1_score = new float[]{0.1f, 0.2f, 0.3f};
		
		//特征点1
		Vertex vertex1 = new Vertex();
		vertex1.setId("1001");
		vertex1.setName("room1001");
		
		//特征点2
		Vertex vertex2 = new Vertex();
		vertex2.setId("1002");
		vertex2.setName("room1002");
		
		//特征点3
		Vertex vertex3 = new Vertex();
		vertex3.setId("1003");
		vertex3.setName("room1003");
		
		
	}
	
}
