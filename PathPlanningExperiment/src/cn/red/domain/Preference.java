package cn.red.domain;

public class Preference {
	private Integer id;
	private int userId;//用户id
	private int vertexId;//节点id
	private float grade;//用户评分
	private int retention;//用户停留时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getVertexId() {
		return vertexId;
	}

	public void setVertexId(int vertexId) {
		this.vertexId = vertexId;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public int getRetention() {
		return retention;
	}

	public void setRetention(int retention) {
		this.retention = retention;
	}

	@Override
	public String toString() {
		return "UserPreference [id=" + id + ", userId=" + userId
				+ ", vertexId=" + vertexId + ", grade=" + grade
				+ ", retention=" + retention + "]";
	}
}
