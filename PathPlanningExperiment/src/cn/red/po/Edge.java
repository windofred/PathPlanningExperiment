package cn.red.po;

public class Edge {
	
	private Integer edgeId;//边的编号
	private String edgeName;//边的名称
	private String edgeType;//边的类型
	private Node source;//边的起始节点
	private Node destination;//边的终止节点
	private Integer startNodeId;//边的起始节点id
	private Integer endNodeId;//边的终止节点id
	private String available;//边可用的时间段
	private boolean accessibility;//边的可达性
	private double weight;//边的权重
	private int direction;//边的方向约束
	
	//无参的构造器
	public Edge(){
		
	}
	
	public Edge(Integer edgeId, Integer startNodeId, Integer endNodeId, double weight){
		this.edgeId = edgeId;
		this.startNodeId = startNodeId;
		this.endNodeId = endNodeId;
		this.weight = weight;
	}
	
	//有参构造器
	public Edge(Integer edgeId, Node source, Node destination, double weight){
		this.edgeId = edgeId;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	public Integer getEdgeId() {
		return edgeId;
	}

	public void setEdgeId(Integer edgeId) {
		this.edgeId = edgeId;
	}

	public String getEdgeName() {
		return edgeName;
	}

	public void setEdgeName(String edgeName) {
		this.edgeName = edgeName;
	}

	public String getEdgeType() {
		return edgeType;
	}

	public void setEdgeType(String edgeType) {
		this.edgeType = edgeType;
	}
	
	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
	}

	public Node getDestination() {
		return destination;
	}

	public void setDestination(Node destination) {
		this.destination = destination;
	}

	public Integer getStartNodeId() {
		return startNodeId;
	}

	public void setStartNodeId(Integer startNodeId) {
		this.startNodeId = startNodeId;
	}

	public Integer getEndNodeId() {
		return endNodeId;
	}

	public void setEndNodeId(Integer endNodeId) {
		this.endNodeId = endNodeId;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}
	
	public boolean isAccessibility() {
		return accessibility;
	}

	public void setAccessibility(boolean accessibility) {
		this.accessibility = accessibility;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Edge [edgeId=" + edgeId + ", edgeName=" + edgeName
				+ ", edgeType=" + edgeType + ", startNodeId=" + startNodeId
				+ ", endNodeId=" + endNodeId + ", available=" + available
				+ ", weight=" + weight + ", direction=" + direction + "]";
	}
	
}
