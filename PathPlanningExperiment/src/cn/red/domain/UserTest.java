package cn.red.domain;

import org.junit.Test;

import cn.red.undirectional.Vertex;

public class UserTest {
	
	@Test
	public void test1() {
		User user = new User();
		user.setId(1);
		user.setName("Jack");
		user.setRetention("10");
		user.setGrade(7.5);
		
		Vertex vertex = new Vertex();
		vertex.setId("1001");
		vertex.setName("room1001");
		vertex.setUser(user);
		
		System.out.println(vertex);
	}
	
}
