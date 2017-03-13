package cn.red.user.cf;

public interface ItemsBased {
	
	//用户最感兴趣的饮食店铺
	public void findFood() throws Exception;
	
	//用户最感兴趣的服装店铺
	public void findCostume() throws Exception;
	
	//用户最感兴趣的电影院
	public void findCinema() throws Exception;
	
}
