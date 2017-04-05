package cn.red.undirectional;

import java.util.ArrayList;
import java.util.List;

import cn.red.dao.EdgeDao;
import cn.red.dao.VertexDao;

public class CreateGraph {

	private static List<Vertex> nodes = new ArrayList<Vertex>();
	private static List<Edge> edges = new ArrayList<Edge>();

	private static List<Edge> edgeList = null;

	public static List<Vertex> getVertexList() throws Exception {
		nodes = VertexDao.readVertexInfo();
		return nodes;
	}

	public static List<Edge> getEdgeList() throws Exception {
		
		edgeList = EdgeDao.readEdgeInfo();

		int laneId = 0;
		int sourceLocNo = 0;
		int destLocNo = 0;
		double length = 0;//路径长度
		double density = 0.0;//拥挤程度
		double weight = 0.0;//权值

		for (int i = 0; i < edgeList.size(); i++) {
			laneId = edgeList.get(i).getId();//边id
			sourceLocNo = edgeList.get(i).getStartVertexId();//边的起始节点id
			destLocNo = edgeList.get(i).getEndVertexId();//边的结束节点id
			length = edgeList.get(i).getLength();//边的长度(暂时自定义)
			density = edgeList.get(i).getDensity();//人流密度(单位面积上人员的数目)
			
			weight = length*density;//权值的计算
			
			addLane(laneId, sourceLocNo, destLocNo, weight);//添加边
		}

		return edges;

	}

	private static void addLane(int laneId, int sourceLocNo, int destLocNo,double duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
		edges.add(lane);
	}
}
