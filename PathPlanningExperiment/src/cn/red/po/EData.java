package cn.red.po;

/**
 * 边的信息
 * 
 * @author Administrator
 *
 */
public class EData {

	private String start;// 边的起点
	private String end;// 边的终点
	private int weight;// 边的权重
	private int direction;// 边的方向性(-1,0,1)

	public EData(String start, String end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
