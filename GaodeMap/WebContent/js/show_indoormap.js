/**
 * 
 */
//示例 初始化地图
var map = new Indoor.Map('mapDiv',{
	//开发者key
    key:'f205273227bc6582f0a84be304d21aac',
    //建筑物id
    buildingId:'B001C80TAL'
});
//由于地图数据使用了异步加载，为避免出错请把所有的逻辑放在mapready事件内
map.once('mapready',function(){
    console.log(map.getFloor());
})


