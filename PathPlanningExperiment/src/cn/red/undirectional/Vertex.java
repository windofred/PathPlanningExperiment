package cn.red.undirectional;

public class Vertex {

	private int id;
	private String name;

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
