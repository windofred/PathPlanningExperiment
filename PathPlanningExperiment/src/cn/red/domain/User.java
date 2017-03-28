package cn.red.domain;

import java.util.List;

import cn.red.undirectional.Vertex;

public class User {

	private int id;
	private String name;
	
	private List<Vertex> vertexs;
	
	public void setVertexs(List<Vertex> vertexs) {
		this.vertexs = vertexs;
	}
	
	public List<Vertex> getVertexs() {
		return vertexs;
	}

	private int retention;//用户在某节点的停留时间
	private float grade;//用户对于某节点的评分

	public int getRetention() {
		return retention;
	}

	public void setRetention(int retention) {
		this.retention = retention;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", retention=" + retention
				+ ", grade=" + grade + "]";
	}

}
