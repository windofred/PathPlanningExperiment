package cn.red.po;

//邻接表中对应的链表的顶点
public class ENode {

	private int ivex;// 该边所指向的顶点的位置
	private int weight;// 该边的权
	private ENode nextEdge;// 指向下一条弧的指针

	public int getIvex() {
		return ivex;
	}

	public void setIvex(int ivex) {
		this.ivex = ivex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public ENode getNextEdge() {
		return nextEdge;
	}

	public void setNextEdge(ENode nextEdge) {
		this.nextEdge = nextEdge;
	}

}
