package cn.red.undirectional;

import java.util.List;

import cn.red.domain.User;

public class Vertex {

	private int id;
	private String name;

	// private List<User> users;

	// public List<User> getUsers() {
	// return users;
	// }
	//
	// public void setUsers(List<User> users) {
	// this.users = users;
	// }

	public Vertex() {

	}

	public Vertex(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Vertex [id=" + id + ", name=" + name + "]";
	}

}
