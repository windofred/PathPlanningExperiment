package cn.red.enumeration;

public enum RouteCongestion {

	NORMAL("正常", 1), SLIGHT("轻度", 2), MEDIUM("中度", 3), SEVERE("重度", 4);

	private String name;
	private int index;

	private RouteCongestion(String name, int index) {
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
