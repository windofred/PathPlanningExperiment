//示例 初始化地图
/**
 * id:地图的div容器ID options:地图选项
 */
var map = new Indoor.Map('mapDiv', {
	// 开发者key
	key : 'f205273227bc6582f0a84be304d21aac',
	// 建筑物id
	buildingId : 'B001C80TAL',
	floorControl : true,
	routeControl : false,// 取消室内路径规划的功能
	highlightFeatrueClick : true

});

// 由于地图数据使用了异步加载，为避免出错请把所有的逻辑放在mapready事件内
/**
 * mapready:地图加载完成时触发
 */
map.once('mapready', function() {
	console.log(map.getFloor());
	console.log(map.getCenter());
	console.log(map.getZoom());
	console.log(map.getMinZoom());
	console.log(map.getMaxZoom());
	console.log(map.getSize());
	console.log(map.getFacilityData());
	console.log(map.getShopData());
})

//获取商铺的经纬度
map.once('click', function(){
	map.hightLightFacility(map.getShopData('六福珠宝'));
})

//创建标记


//路径规划
map.once('dblclick', function(){
	var start = {};
	var stop = {};
	start.x = 104.07434;
	start.y = 30.68628;
	start.floor = 1;
	
	stop.x = 104.07426;
	stop.y = 30.68667;
	stop.floor = 2;
	
	//成功回调，返回路算的信息
	function successback(routeInfo){
		console.log(routeInfo);
	}
	//失败回调，返回路算的错误信息
	function errorback(msg){
		console.log(msg);
	}
	
	//开始路算
	map.routePath(start, stop, successback, errorback, {showTip:false});
})




