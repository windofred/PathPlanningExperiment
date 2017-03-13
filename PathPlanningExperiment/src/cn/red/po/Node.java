package cn.red.po;

import java.util.List;

public class Node {
	
	private Integer nodeId;//节点编号
	private String nodeName;//节点名称
	private String nodeType;//节点类型
	private String available;//节点可用的时间段
	private boolean accessibility;//节点的可达性
	private int floorId;//节点所在楼层
	private int edgeNum;//节点相关联边的数量
	private List<Integer> edgeId;//节点相关联边的ID
	private int adjNodeNum;//节点相邻节点的数量
	private List<Integer> adjNodeId;//节点相邻节点的ID
	
	private double x;//节点的x坐标
	private double y;//节点的y坐标
	private double z;//节点的z坐标
	
	//无参的构造器
	public Node(){
		
	}
	
	public Node(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}
	
	//判断该节点是否可用
	public boolean isAccessibility() {
		return accessibility;
	}

	public void setAccessibility(boolean accessibility) {
		this.accessibility = accessibility;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public int getEdgeNum() {
		return edgeNum;
	}

	public void setEdgeNum(int edgeNum) {
		this.edgeNum = edgeNum;
	}

	public List<Integer> getEdgeId() {
		return edgeId;
	}

	public void setEdgeId(List<Integer> edgeId) {
		this.edgeId = edgeId;
	}
	
	public int getAdjNodeNum() {
		return adjNodeNum;
	}

	public void setAdjNodeNum(int adjNodeNum) {
		this.adjNodeNum = adjNodeNum;
	}

	public List<Integer> getAdjNodeId() {
		return adjNodeId;
	}

	public void setAdjNodeId(List<Integer> adjNodeId) {
		this.adjNodeId = adjNodeId;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Node [nodeId=" + nodeId + ", nodeName=" + nodeName
				+ ", nodeType=" + nodeType + ", available=" + available
				+ ", floorId=" + floorId + ", edgeNum=" + edgeNum + ", edgeId="
				+ edgeId + ", adjNodeNum=" + adjNodeNum + ", adjNodeId="
				+ adjNodeId + ", x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}
