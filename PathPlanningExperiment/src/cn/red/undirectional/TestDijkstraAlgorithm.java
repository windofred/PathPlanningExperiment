package cn.red.undirectional;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * Dijkstra特点： 1.最短路径的子路径仍然是最短:子路径最短的路径之和仍然是整体最短路径
 * 
 * @author Administrator
 *
 */
public class TestDijkstraAlgorithm {

	private List<Vertex> nodes;
	private List<Edge> edges;

	@Test
	public void testExcute() {

		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		for (int i = 0; i < 11; i++) {
			Vertex location = new Vertex("Node_" + i, "Node_" + i);
			nodes.add(location);
		}

		// 为无向图添加边(权值是固定的)
		addLane("Edge_01", 0, 1, 3);
		addLane("Edge_10", 1, 0, 3);

		addLane("Edge_04", 0, 4, 4);
		addLane("Edge_40", 4, 0, 4);

		addLane("Edge_07", 0, 7, 7);
		addLane("Edge_70", 7, 0, 7);

		addLane("Edge_12", 1, 2, 9);
		addLane("Edge_21", 2, 1, 9);

		addLane("Edge_14", 1, 4, 9);
		addLane("Edge_41", 4, 1, 9);

		addLane("Edge_24", 2, 4, 7);
		addLane("Edge_42", 4, 2, 7);

		addLane("Edge_25", 2, 5, 8);
		addLane("Edge_52", 5, 2, 8);

		addLane("Edge_23", 2, 3, 15);
		addLane("Edge_32", 3, 2, 15);

		addLane("Edge_26", 2, 6, 17);
		addLane("Edge_62", 6, 2, 17);

		addLane("Edge_36", 3, 6, 8);
		addLane("Edge_63", 6, 3, 8);

		addLane("Edge_310", 3, 10, 20);
		addLane("Edge_103", 10, 3, 20);

		addLane("Edge_45", 4, 5, 5);
		addLane("Edge_54", 5, 4, 5);

		addLane("Edge_47", 4, 7, 7);
		addLane("Edge_74", 7, 4, 7);

		addLane("Edge_48", 4, 8, 3);
		addLane("Edge_84", 8, 4, 3);

		addLane("Edge_56", 5, 6, 16);
		addLane("Edge_65", 6, 5, 16);

		addLane("Edge_58", 5, 8, 4);
		addLane("Edge_85", 8, 5, 4);

		addLane("Edge_68", 6, 8, 20);
		addLane("Edge_86", 8, 6, 20);

		addLane("Edge_69", 6, 9, 10);
		addLane("Edge_96", 9, 6, 10);

		addLane("Edge_610", 6, 10, 20);
		addLane("Edge_106", 10, 6, 20);

		addLane("Edge_78", 7, 8, 2);
		addLane("Edge_87", 8, 7, 2);

		addLane("Edge_89", 8, 9, 16);
		addLane("Edge_98", 9, 8, 16);

		addLane("Edge_910", 9, 10, 18);
		addLane("Edge_109", 10, 9, 18);

		// Lets check from location Loc_1 to Loc_10
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

		System.out.println("第一段路径：");
		dijkstra.execute(nodes.get(0));// 起点1
		LinkedList<Vertex> path1 = dijkstra.getPath(nodes.get(8));// 终点1

		// 路径一：分段路径一
		assertNotNull(path1);
		assertTrue(path1.size() > 0);

		for (Vertex vertex : path1) {
			System.out.println(vertex);
		}

		System.out.println("第二段路径：");
		dijkstra.execute(nodes.get(8));// 起点2
		LinkedList<Vertex> path2 = dijkstra.getPath(nodes.get(10));// 终点2

		// 路径二：分段路径二
		assertNotNull(path2);
		assertTrue(path2.size() > 0);

		for (Vertex vertex : path2) {
			System.out.println(vertex);
		}

	}

	private void addLane(String laneId, int sourceLocNo, int destLocNo,
			int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo),
				nodes.get(destLocNo), duration);
		edges.add(lane);
	}

}
