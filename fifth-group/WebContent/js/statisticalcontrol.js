$(function(){
	var myChart = echarts.init(document.getElementById("date_distribution"));
	getDateDistribution(function(data){
		console.log(typeof eval(data));
		myChart.setOption(dateDistriOption.call(eval(data)));
	});
});





