package cn.red.po;

import java.util.List;

public class Graph {
	
	private List<Node> nodes;
	private List<Edge> edges;
	
	public Graph(List<Node> Nodes, List<Edge> edges){
		this.nodes = Nodes;
		this.edges = edges;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> Nodees) {
		this.nodes = Nodees;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}


