function getVirtulData(year) {
    year = year || '2017';
    var date =+echarts.number.parseDate(year + '-01-01');
    var end =+echarts.number.parseDate((+year + 1) + '-01-01');
    var dayTime = 3600 * 24 * 1000;
    var data = [];
    for (var time = date; time < end; time += dayTime) {
        data.push([
            echarts.format.formatTime('yyyy-MM-dd', time),
            Math.floor(Math.random() * 10000)
        ]);
    }
    return data;
}
function getDateDistribution(recall){
	 $.ajax({
		 url:"statistical!getDateDistribution.action",
		 type:"GET",
		 data:{
			 "year":"2017"
		 },
		 error:function(){
			 alert("请检查网络");
		 },
		 success:function(data){
			 recall(data);
		 }
		 
	 });
}