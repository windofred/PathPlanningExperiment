package cn.red.po;

import org.junit.Test;

public class ListUDGTest {

	@Test
	public void testDijkstra() {
		
		String[] vexs = {"A", "B", "C", "D", "E", "F", "G"};
		EData[] edges = {
				// 起点 终点 权
				new EData("A", "B", 12), new EData("A", "F", 16),
				new EData("A", "G", 14), new EData("B", "C", 10),
				new EData("B", "F", 7), new EData("C", "D", 3),
				new EData("C", "E", 5), new EData("C", "F", 6),
				new EData("D", "E", 4), new EData("E", "F", 2),
				new EData("E", "G", 8), new EData("F", "G", 9)};
		
		ListUDG pG = new ListUDG(vexs, edges);
		
		//广度优先遍历
		//pG.BFS();
		
		int[] prev = new int[pG.getmVexs().length];
		int[] dist = new int[pG.getmVexs().length];
		// dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
		long startTime = System.currentTimeMillis();
		pG.dijkstra(5, prev, dist);
		long endTime = System.currentTimeMillis();
		System.out.println("耗时：" + (endTime-startTime));
		
	}

}
