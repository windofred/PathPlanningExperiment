package cn.red.collaborative.filtering;

//协同过滤的接口
public interface ItemsBased {
	
	//用户最感兴趣的饮食节点
	public void findFood() throws Exception;
	
	//用户最感兴趣的服装节点
	public void findCostume() throws Exception;
	
	//用户最感兴趣的化妆品节点
	public void findCosmetic() throws Exception;
	
}
