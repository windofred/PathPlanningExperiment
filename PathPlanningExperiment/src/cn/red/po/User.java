package cn.red.po;

/**
 * 用户信息
 * 
 * @author Administrator
 *
 */
public class User {

	private Integer id;
	private String name;
	private int age;
	private String role;// 用户的访问权限

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
