package cn.red.undirectional;

public class Edge {
	private int id;
	private Vertex source;
	private Vertex destination;
	private int weight;

	private int startVertexId;
	private int endVertexId;

	// 为边添加人流量
	private double density;

	public Edge() {

	}

	public Edge(int id, Vertex source, Vertex destination, int weight, double density) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.density = density;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public Vertex getDestination() {
		return destination;
	}

	public Vertex getSource() {
		return source;
	}

	public int getWeight() {
		return weight;
	}

	public int getStartVertexId() {
		return startVertexId;
	}

	public void setStartVertexId(int startVertexId) {
		this.startVertexId = startVertexId;
	}

	public int getEndVertexId() {
		return endVertexId;
	}

	public void setEndVertexId(int endVertexId) {
		this.endVertexId = endVertexId;
	}

	public double getDensity() {
		return density;
	}

	public void setDensity(double density) {
		this.density = density;
	}

	@Override
	public String toString() {
		return "Edge [id=" + id + ", source=" + source + ", destination="
				+ destination + ", weight=" + weight + ", startVertexId="
				+ startVertexId + ", endVertexId=" + endVertexId + ", density="
				+ density + "]";
	}

}
