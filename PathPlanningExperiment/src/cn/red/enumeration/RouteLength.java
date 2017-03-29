package cn.red.enumeration;


public enum RouteLength {
	

	SHORTEST("最短", 1), LONGEST("最长", 2);

	private String name;
	private int index;

	private RouteLength(String name, int index) {
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
