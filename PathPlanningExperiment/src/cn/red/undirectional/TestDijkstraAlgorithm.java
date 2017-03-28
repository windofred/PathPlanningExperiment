package cn.red.undirectional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.red.domain.Preference;
import cn.red.domain.UserPreference;
import cn.red.sort.QuickSort;

/**
 * 
 * Dijkstra特点： 1.最短路径的子路径仍然是最短:子路径最短的路径之和仍然是整体最短路径
 * 
 * @author Administrator
 *
 */
public class TestDijkstraAlgorithm {

	private List<Vertex> nodes = null;
	private List<Edge> edges = null;

	@Test
	public void testExcute() throws Exception {

		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		for (int i = 0; i < 11; i++) {
			Vertex location = new Vertex(String.valueOf(i), String.valueOf(i));
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
		Graph graph = new Graph(nodes, edges);//创建图
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		//获得用户1偏好的前K(K=3)个节点
		List<Preference> mostPreferenceList = UserPreference.recommandPreferences();
		int vertex1_id = Integer.parseInt(mostPreferenceList.get(0).getVertexId());
		int vertex2_id = Integer.parseInt(mostPreferenceList.get(1).getVertexId());
		int vertex3_id = Integer.parseInt(mostPreferenceList.get(2).getVertexId());
		
		//System.out.println("第一段路径：");
		dijkstra.execute(nodes.get(0));// 起点1
		LinkedList<Vertex> path1 = dijkstra.getPath(nodes.get(vertex1_id));// 终点1
		
		int path1_length = path1.size();
		int path1_sum = 0;//路段1的最短距离 
		for(int i=0; i<path1_length-1; i++) {
			path1_sum += dijkstra.getDistance2(path1.get(i), path1.get(i+1));
		}
		
		Map<Integer, Integer> path1Map = new HashMap<Integer, Integer>();
		path1Map.put(path1_sum, vertex1_id);
		
		assertNotNull(path1);
		assertTrue(path1.size() > 0);
		

		//System.out.println("第二段路径：");
		dijkstra.execute(nodes.get(0));// 起点2
		LinkedList<Vertex> path2 = dijkstra.getPath(nodes.get(vertex2_id));// 终点2
		int path2_length = path2.size();
		int path2_sum = 0;//路段2的最短距离 
		for(int i=0; i<path2_length-1; i++) {
			path2_sum += dijkstra.getDistance2(path2.get(i), path2.get(i+1));
		}
		Map<Integer, Integer> path2Map = new HashMap<Integer, Integer>();
		path2Map.put(path2_sum, vertex2_id);

		assertNotNull(path2);
		assertTrue(path2.size() > 0);

		//System.out.println("第三段路径：");
		dijkstra.execute(nodes.get(0));// 起点2
		LinkedList<Vertex> path3 = dijkstra.getPath(nodes.get(vertex3_id));// 终点2
		int path3_length = path3.size();
		int path3_sum = 0;//路段3的最短距离 
		for(int i=0; i<path3_length-1; i++) {
			path3_sum += dijkstra.getDistance2(path3.get(i), path3.get(i+1));
		}
		
		Map<Integer, Integer> path3Map = new HashMap<Integer, Integer>();
		path3Map.put(path3_sum, vertex3_id);

		assertNotNull(path3);
		assertTrue(path2.size() > 0);
		
		//获得距离用户当前位置最近的节点的id
		int vertex1Id = 0;//最近的节点
		int vertex2Id = 0;//次近的节点
		int vertex3Id = 0;//最远的节点

		//根据用户的当前位置获得离偏好点距离的从近及远的排序
		int[] path_sum = new int[]{path1_sum, path2_sum, path3_sum};
		QuickSort.sort(path_sum);
		
		if(path1_sum==path_sum[0]) {
			vertex1Id = path1Map.get(path1_sum);
		}else if(path2_sum==path_sum[0]) {
			vertex1Id = path2Map.get(path2_sum);
		}else if(path3_sum==path_sum[0]) {
			vertex1Id = path3Map.get(path3_sum);
		}
		
		if(path1_sum==path_sum[1]) {
			vertex2Id = path1Map.get(path1_sum);
		}else if(path2_sum==path_sum[1]) {
			vertex2Id = path2Map.get(path2_sum);
		}else if(path3_sum==path_sum[1]) {
			vertex2Id = path3Map.get(path3_sum);
		}
		if(path1_sum==path_sum[2]) {
			vertex3Id = path1Map.get(path1_sum);
		}else if(path2_sum==path_sum[2]) {
			vertex3Id = path2Map.get(path2_sum);
		}else if(path3_sum==path_sum[2]) {
			vertex3Id = path3Map.get(path3_sum);
		}
		
		//规划起点到距离起点最近的节点的路径
		dijkstra.execute(nodes.get(0));// 起点1
		LinkedList<Vertex> routePath1 = dijkstra.getPath(nodes.get(vertex1Id));// 终点1
		
		dijkstra.execute(nodes.get(vertex1Id));
		LinkedList<Vertex> routePath2 = dijkstra.getPath(nodes.get(vertex2Id));
		
		dijkstra.execute(nodes.get(vertex2Id));
		LinkedList<Vertex> routePath3 = dijkstra.getPath(nodes.get(vertex3Id));
		
		//遍历routePath1
		for(Vertex v1 : routePath1) {
			System.out.println(v1);
		}
		for(Vertex v2 : routePath2) {
			System.out.println(v2);
		}
		for(Vertex v3 : routePath3) {
			System.out.println(v3);
		}
		
	}

	private void addLane(String laneId, int sourceLocNo, int destLocNo,
			int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo),
				nodes.get(destLocNo), duration);
		edges.add(lane);
	}
	

}
