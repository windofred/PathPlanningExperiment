package cn.red.po;

import java.io.IOException;
import java.util.Scanner;

//邻接链表的方式
public class ListUDG {

	private static int INF = Integer.MAX_VALUE;// 表示无穷大
	
	private int mEdgNum;// 边的数量
	private VNode[] mVexs;// 顶点数组

	public int getmEdgNum() {
		return mEdgNum;
	}

	public void setmEdgNum(int mEdgNum) {
		this.mEdgNum = mEdgNum;
	}

	public VNode[] getmVexs() {
		return mVexs;
	}

	public void setmVexs(VNode[] mVexs) {
		this.mVexs = mVexs;
	}

	// 创建图(用已提供的矩阵)
	public ListUDG(String[] vexs, EData[] edges) {
		// 获得顶点的长度和边的长度
		int vlen = vexs.length;
		int elen = edges.length;

		// 初始化顶点
		mVexs = new VNode[vlen];
		for (int i = 0; i < mVexs.length; i++) {
			mVexs[i] = new VNode();
			mVexs[i].setData(vexs[i]);
			mVexs[i].setFirstEdge(null);
		}

		// 初始化边
		mEdgNum = elen;
		for (int i = 0; i < elen; i++) {
			// 读取边的起始顶点和结束顶点
			String c1 = edges[i].getStart();
			String c2 = edges[i].getEnd();
			int weight = edges[i].getWeight();

			// 读取边的起始顶点和结束顶点
			int p1 = getPosition(c1);
			int p2 = getPosition(c2);
			// 初始化node1
			ENode node1 = new ENode();
			node1.setIvex(p2);
			node1.setWeight(weight);
			// 将node1链接到"p1所在链表的末尾"
			if (mVexs[p1].getFirstEdge() == null) {
				mVexs[p1].setFirstEdge(node1);
			} else {
				linkLast(mVexs[p1].getFirstEdge(), node1);
			}
			// 初始化node2
			ENode node2 = new ENode();
			node2.setIvex(p1);
			node2.setWeight(weight);
			// 将node2链接到"p2所在链表的末尾"
			if (mVexs[p2].getFirstEdge() == null) {
				mVexs[p2].setFirstEdge(node2);
			} else {
				linkLast(mVexs[p2].getFirstEdge(), node2);
			}

		}

	}

	// 返回ch的位置
	public int getPosition(String ch) {
		for (int i = 0; i < mVexs.length; i++) {
			if (mVexs[i].getData() == ch) {
				return i;
			}
		}
		return -1;
	}

	// 将node节点链接到链表的最后
	public void linkLast(ENode list, ENode node) {

		ENode p = list;

		while (p.getNextEdge() != null) {
			p = p.getNextEdge();
		}
		p.setNextEdge(node);
	}

	// 读取一个整型输入
	public int readInt() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	// 获取边<start,end>的权值
	private int getWeight(int start, int end) {

		if (start == end)
			return 0;

		ENode node = mVexs[start].getFirstEdge();
		while (node != null) {
			if (end == node.getIvex())
				return node.getWeight();
			node = node.getNextEdge();
		}

		return INF;
	}

	// 广度优先搜索（类似于树的层次遍历）
	public void BFS() {
		int head = 0;
		int rear = 0;
		int[] queue = new int[mVexs.length]; // 辅组队列
		boolean[] visited = new boolean[mVexs.length]; // 顶点访问标记

		for (int i = 0; i < mVexs.length; i++)
			visited[i] = false;

		System.out.printf("BFS: ");
		for (int i = 0; i < mVexs.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				System.out.printf("%s ", mVexs[i].getData());
				queue[rear++] = i; // 入队列
			}

			while (head != rear) {
				int j = queue[head++]; // 出队列
				ENode node = mVexs[j].getFirstEdge();
				while (node != null) {
					int k = node.getIvex();
					if (!visited[k]) {
						visited[k] = true;
						System.out.printf("%s ", mVexs[k].getData());
						queue[rear++] = k;
					}
					node = node.getNextEdge();
				}
			}
		}
		System.out.printf("\n");
	}

	/**
	 * Dijkstra算法
	 * 
	 * @param vs：起点
	 *           
	 * @param prev：前驱顶点数组
	 *           
	 * @param dist：距离顶点数组
	 *            
	 * 
	 */
	public void dijkstra(int vs, int[] prev, int[] dist) {
		
		boolean[] flag = new boolean[mVexs.length];
		// 初始化
		for (int i = 0; i < mVexs.length; i++) {
			flag[i] = false;// 顶点i的最短路径还没找到
			prev[i] = 0;// 顶点i的前驱顶点为0
			dist[i] = getWeight(vs, i);// 顶点i的最短路径为到起点vs的长度
		}

		// 对"顶点vs"自身进行初始化
		flag[vs] = true;
		dist[vs] = 0;

		// 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
		int k = 0;
		for (int i = 1; i < mVexs.length; i++) {
			// 寻找当前最小的路径；
			// 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
			int min = INF;
			for (int j = 0; j < mVexs.length; j++) {
				if (flag[j] == false && dist[j] < min) {
					min = dist[j];
					k = j;
				}
			}
			// 标记"顶点k"为已经获取到最短路径
			flag[k] = true;

			// 修正当前最短路径和前驱顶点
			// 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
			for (int j = 0; j < mVexs.length; j++) {
				int tmp = getWeight(k, j);
				tmp = (tmp == INF ? INF : (min + tmp)); // 防止溢出
				if (flag[j] == false && (tmp < dist[j])) {
					dist[j] = tmp;
					prev[j] = k;
				}
			}
		}

		// 打印dijkstra最短路径的结果
		System.out.printf("dijkstra(%s): \n", mVexs[vs].getData());
		for (int i = 0; i < mVexs.length; i++) {
			System.out.printf("  shortest(%s, %s)=%d\n", mVexs[vs].getData(),
					mVexs[i].getData(), dist[i]);
		}
	}

}
