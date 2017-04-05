package cn.red.test;

import cn.red.service.RoutePlanning;


/**
 * 
 * Dijkstra特点： 1.最短路径的子路径仍然是最短:子路径最短的路径之和仍然是整体最短路径
 * 
 * @author Administrator
 *
 */
public class TestDijkstraAlgorithm {
	
	public static void main(String[] args) throws Exception {
		//根据 距离 和 人流量大小 来计算最优路径
		RoutePlanning.routeByDistanceAndCongestion();
	}

}
