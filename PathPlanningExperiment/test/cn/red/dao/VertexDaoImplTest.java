package cn.red.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class VertexDaoImplTest {

	//查找顶点的信息
	@Test
	public void testFindVertexInfo() {
		
		VertexDao vertexDao = new VertexDaoImpl();
		List<String> list = vertexDao.findVertexInfo();
		
		System.out.println();
	}

}
