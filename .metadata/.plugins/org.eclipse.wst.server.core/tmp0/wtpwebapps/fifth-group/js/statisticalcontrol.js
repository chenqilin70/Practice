$(function(){
	var myChart = echarts.init(document.getElementById("date_distribution"));
	getDateDistribution(function(data){
		myChart.setOption(dateDistriOption.call(eval(data)));
	});
	
	
	var addr_distri=echarts.init(document.getElementById("addr_distribution"));
	getAddrData(function(addr_data){
		addr_distri.setOption(getOrderDistributeOption.call(eval(addr_data)));
	});
	
	
});





