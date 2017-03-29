package cn.red.enumeration;

public enum RouteComplexity {

	EASY("简单", 1), GENERAL("一般", 2), Complex("复杂", 3);

	private String name;
	private int index;

	private RouteComplexity(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
