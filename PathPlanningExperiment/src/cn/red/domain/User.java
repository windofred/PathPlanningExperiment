package cn.red.domain;

public class User {

	private Integer id;
	private String name;

	private String retention;//用户在某节点的停留时间
	private double grade;//用户对于某节点的评分

	public String getRetention() {
		return retention;
	}

	public void setRetention(String retention) {
		this.retention = retention;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", retention=" + retention
				+ ", grade=" + grade + "]";
	}

}
