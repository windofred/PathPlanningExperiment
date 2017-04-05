package cn.red.undirectional;

public class Edge {
	private int id;
	private Vertex source;
	private Vertex destination;
	private int startVertexId;
	private int endVertexId;

	private double length;//边的长度

	private double weight;//权值

	private double density;//为边添加人流量

	public Edge() {

	}

	public Edge(int id, Vertex source, Vertex destination, double weight) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
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

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
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
