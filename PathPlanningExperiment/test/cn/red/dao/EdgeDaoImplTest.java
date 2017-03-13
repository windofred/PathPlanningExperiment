package cn.red.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class EdgeDaoImplTest {

	@Test
	public void testFindEdgeInfo() {

		EdgeDao edgeDao = new EdgeDaoImpl();
		edgeDao.findEdgeInfo();
		
	}

}
