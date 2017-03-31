package cn.red.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import cn.red.domain.Preference;
import cn.red.domain.UserPreference;
import cn.red.sort.QuickSort;
import cn.red.undirectional.CreateGraph;
import cn.red.undirectional.DijkstraAlgorithm;
import cn.red.undirectional.Edge;
import cn.red.undirectional.Graph;
import cn.red.undirectional.Vertex;

public class RoutePlanning {

	private static List<Vertex> nodes = new ArrayList<Vertex>();
	private static List<Edge> edges = new ArrayList<Edge>();
	// 用户保存用户输入的偏好信息
	private static List<String> inputInfo = new ArrayList<String>();

	/**
	 * 1.根据用户的停留时间和评分两个标准，为用户推荐3个偏好点 2.将3个偏好点作为中间点或终点,并将偏好点距离用户当前位置的长度作排序
	 * 3.规划一条遍历用户偏好点的一条路径长度最短路径
	 * 
	 * @throws Exception
	 */
	public static void routeByDistance() throws Exception {

		nodes = CreateGraph.getVertexList();
		edges = CreateGraph.getEdgeList();

		// Lets check from location Loc_1 to Loc_10
		Graph graph = new Graph(nodes, edges);// 创建图
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		// 获得用户1偏好的前K(K=3)个节点
		List<Preference> mostPreferenceList = UserPreference
				.recommandPreferences();
		int vertex1_id = mostPreferenceList.get(0).getVertexId();
		int vertex2_id = mostPreferenceList.get(1).getVertexId();
		int vertex3_id = mostPreferenceList.get(2).getVertexId();

		// System.out.println("第一段路径：");
		dijkstra.execute(nodes.get(0));// 起点1
		LinkedList<Vertex> path1 = dijkstra.getPath(nodes.get(vertex1_id));// 终点1

		int path1_length = path1.size();
		int path1_sum = 0;// 路段1的最短距离
		for (int i = 0; i < path1_length - 1; i++) {
			path1_sum += dijkstra.getDistance2(path1.get(i), path1.get(i + 1));
		}

		Map<Integer, Integer> path1Map = new HashMap<Integer, Integer>();
		path1Map.put(path1_sum, vertex1_id);

		assertNotNull(path1);
		assertTrue(path1.size() > 0);

		// System.out.println("第二段路径：");
		dijkstra.execute(nodes.get(0));// 起点2
		LinkedList<Vertex> path2 = dijkstra.getPath(nodes.get(vertex2_id));// 终点2
		int path2_length = path2.size();
		int path2_sum = 0;// 路段2的最短距离
		for (int i = 0; i < path2_length - 1; i++) {
			path2_sum += dijkstra.getDistance2(path2.get(i), path2.get(i + 1));
		}
		Map<Integer, Integer> path2Map = new HashMap<Integer, Integer>();
		path2Map.put(path2_sum, vertex2_id);

		assertNotNull(path2);
		assertTrue(path2.size() > 0);

		// System.out.println("第三段路径：");
		dijkstra.execute(nodes.get(0));// 起点2
		LinkedList<Vertex> path3 = dijkstra.getPath(nodes.get(vertex3_id));// 终点2
		int path3_length = path3.size();
		int path3_sum = 0;// 路段3的最短距离
		for (int i = 0; i < path3_length - 1; i++) {
			path3_sum += dijkstra.getDistance2(path3.get(i), path3.get(i + 1));
		}

		Map<Integer, Integer> path3Map = new HashMap<Integer, Integer>();
		path3Map.put(path3_sum, vertex3_id);

		assertNotNull(path3);
		assertTrue(path2.size() > 0);

		// 获得距离用户当前位置最近的节点的id
		int vertex1Id = 0;// 最近的节点
		int vertex2Id = 0;// 次近的节点
		int vertex3Id = 0;// 最远的节点

		// 根据用户的当前位置获得离偏好点距离的从近及远的排序
		int[] path_sum = new int[] { path1_sum, path2_sum, path3_sum };
		QuickSort.sort(path_sum);

		if (path1_sum == path_sum[0]) {
			vertex1Id = path1Map.get(path1_sum);
		} else if (path2_sum == path_sum[0]) {
			vertex1Id = path2Map.get(path2_sum);
		} else if (path3_sum == path_sum[0]) {
			vertex1Id = path3Map.get(path3_sum);
		}

		if (path1_sum == path_sum[1]) {
			vertex2Id = path1Map.get(path1_sum);
		} else if (path2_sum == path_sum[1]) {
			vertex2Id = path2Map.get(path2_sum);
		} else if (path3_sum == path_sum[1]) {
			vertex2Id = path3Map.get(path3_sum);
		}
		if (path1_sum == path_sum[2]) {
			vertex3Id = path1Map.get(path1_sum);
		} else if (path2_sum == path_sum[2]) {
			vertex3Id = path2Map.get(path2_sum);
		} else if (path3_sum == path_sum[2]) {
			vertex3Id = path3Map.get(path3_sum);
		}

		// 规划起点到距离起点最近的节点的路径
		dijkstra.execute(nodes.get(0));// 起点1
		LinkedList<Vertex> routePath1 = dijkstra.getPath(nodes.get(vertex1Id));// 终点1

		dijkstra.execute(nodes.get(vertex1Id));
		LinkedList<Vertex> routePath2 = dijkstra.getPath(nodes.get(vertex2Id));

		dijkstra.execute(nodes.get(vertex2Id));
		LinkedList<Vertex> routePath3 = dijkstra.getPath(nodes.get(vertex3Id));

		System.out.println("用户个性化的路径：");
		// 遍历routePath1
		for (Vertex v1 : routePath1) {
			System.out.println(v1);
		}
		for (Vertex v2 : routePath2) {
			System.out.println(v2);
		}
		for (Vertex v3 : routePath3) {
			System.out.println(v3);
		}

	}

	/**
	 * 1.路径复杂度、路径长度、拥挤长度
	 */
	public static void routeByWeight() {
		
	}

	// 读取用户的输入并返回：路径复杂度、路径长度、拥挤程度
	public static List<String> readInfoByUser() {

		Scanner scanner = new Scanner(System.in);

		System.out.print("路径复杂度：");
		String routeComplex = scanner.next();

		System.out.print("路径长度：");
		String routeDistance = scanner.next();

		System.out.print("拥挤程度：");
		String routeCrowd = scanner.next();

		inputInfo.add(routeComplex);
		inputInfo.add(routeDistance);
		inputInfo.add(routeCrowd);

		scanner.close();

		return inputInfo;

	}
	
	//计算路径复杂度的影响因子
	
	
	//计算路径长度的影响因子
	
	
	@Test
	public void test() {
		double c = RoutePlanning.computeCongestion();
		System.out.println(c);
	}
	
	//计算拥挤程度的影响因子
	//1.获取用户的输入偏好信息
	//2.根据偏好程度计算相应的影响值
	public static double computeCongestion() {
		
//		List<String> list = readInfoByUser();
//		String congestion = list.get(2);
		
		//定义相关的参数值
		double velocity = 0.0;//行人的平均速度
		final double commonVelocity = 1.4;//行人正常速度(m/s)
		//假设已知人流量大小
		double p = 3.0;//假设人流量大小为3.0(单位面积上的人数)
		
		double c = 0.0;//拥堵情况影响因子
		
		//人流范围->速度大小/平均速度->影响大小
		//根据人流量大小，计算行人的通行速度
		if(0<p && p<=0.75) {
			velocity = 1.4;
			c = velocity/commonVelocity;
			System.out.println("对应的拥挤程度为正常...");
		}else if(0.75<p && p<=2) {
			velocity = 1.24;
			c = velocity/commonVelocity;
			System.out.println("对应的拥挤程度为轻度...");
		}else if(2<p && p<=3.5) {
			velocity = 0.69;
			c = velocity/commonVelocity;
			System.out.println("对应的拥挤程度为中度...");
		}else if(p>3.5) {
			velocity = 0.15;
			c = velocity/commonVelocity;
			System.out.println("对应的拥挤程度为重度...");
		}
		
		//返回影响因子c
		return c;
		
		//根据行人的通行速度，计算其影响值c
		
		
		//模拟用户的输入，来判断其偏好具体信息
//		if(RouteCongestion.NORMAL.getName().equalsIgnoreCase(congestion)) {
//			System.out.println("用户的偏好为正常...");
//		}
//		if(RouteCongestion.SLIGHT.getName().equalsIgnoreCase(congestion)) {
//			System.out.println("用户的偏好为轻度...");
//		}
//		if(RouteCongestion.MEDIUM.getName().equalsIgnoreCase(congestion)) {
//			System.out.println("用户的偏好为中度...");
//		}
//		if(RouteCongestion.SEVERE.getName().equalsIgnoreCase(congestion)) {
//			System.out.println("用户的偏好为重度...");
//		}
		
	}

}
