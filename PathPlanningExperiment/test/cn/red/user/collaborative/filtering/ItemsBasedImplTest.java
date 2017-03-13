package cn.red.user.collaborative.filtering;

import org.junit.Test;

import cn.red.collaborative.filtering.ItemsBased;
import cn.red.collaborative.filtering.ItemsBasedImpl;

//测试基于内容的推荐算法
public class ItemsBasedImplTest {

	//推荐饮食
	@Test
	public void testFindFood() throws Exception {
		ItemsBased itemsBased = new ItemsBasedImpl();
		itemsBased.findFood();
	}

	//推荐服饰
	@Test
	public void testFindCostume() throws Exception {
		ItemsBased itemsBased = new ItemsBasedImpl();
		itemsBased.findCostume();
	}

	//推荐化妆品
	@Test
	public void testFindCosmetic() throws Exception {
		ItemsBased itemsBased = new ItemsBasedImpl();
		itemsBased.findCosmetic();
	}

}
