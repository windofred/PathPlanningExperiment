package cn.red.domain;

import java.util.List;

import org.junit.Test;

public class UserTest {
	
	@Test
	public void test1() throws Exception {
		System.out.println("用户的偏好点：");
		List<Preference> list = UserPreference.recommandPreferences();
		System.out.println(list.size());
	}
	
}
