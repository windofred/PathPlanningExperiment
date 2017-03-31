package cn.red.undirectional;

import java.util.ArrayList;
import java.util.List;

import cn.red.dao.EdgeDao;
import cn.red.dao.VertexDao;

public class CreateGraph {

	private static List<Vertex> nodes = new ArrayList<Vertex>();
	private static List<Edge> edges = new ArrayList<Edge>();

	// 获得边集
	private static List<Edge> edgeList = null;

	// 获得节点集合
	public static List<Vertex> getVertexList() throws Exception {
		nodes = VertexDao.readVertexInfo();

		return nodes;
	}

	// 获得边的集合
	public static List<Edge> getEdgeList() throws Exception {

		edgeList = EdgeDao.readEdgeInfo();

		int laneId = 0;
		int sourceLocNo = 0;
		int destLocNo = 0;
		int weight = 0;
		double density = 0.0;

		for (int i = 0; i < edgeList.size(); i++) {
			laneId = edgeList.get(i).getId();
			sourceLocNo = edgeList.get(i).getStartVertexId();
			destLocNo = edgeList.get(i).getEndVertexId();
			weight = edgeList.get(i).getWeight();
			density = edgeList.get(i).getDensity();
			addLane(laneId, sourceLocNo, destLocNo, weight, density);
		}

		return edges;

	}

	// 添加边
	private static void addLane(int laneId, int sourceLocNo, int destLocNo,int duration,double density) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration, density);
		edges.add(lane);
	}
}
