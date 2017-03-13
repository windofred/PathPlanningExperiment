package cn.red.user.cf;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemsBasedImplTest {

	@Test
	public void testFindFood() throws Exception {
		ItemsBased itemsBased = new ItemsBasedImpl();
		itemsBased.findFood();
	}

	@Test
	public void testFindCostume() throws Exception {
		ItemsBased itemsBased = new ItemsBasedImpl();
		itemsBased.findCostume();
	}

	@Test
	public void testFindCinema() throws Exception {
		ItemsBased itemsBased = new ItemsBasedImpl();
		itemsBased.findCinema();
	}

}
