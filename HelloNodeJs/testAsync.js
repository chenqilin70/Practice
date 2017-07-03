var async=require('async');

function oneFun(){
	var j=0;
	setInterval(function(){
		console.log("aaa"+new Date());
		j++;
		if(j==3){
			clearInterval(this);
		}
	},1000);
	console.log("oneFun");
}
function twoFun(){
	var j=0;
	setInterval(function(){
		console.log("bbb"+new Date());
		j++;
		if(j==3){
			clearInterval(this);
		}
	},1000);
	console.log("twoFun");
}
//oneFun();
//twoFun();


function exec(){
	async.waterfall(
		[
			function(done){
				var j=0;
				setInterval(function(){
					console.log("aaa"+new Date());
					j++;
					if(j==3){
						clearInterval(this);
						done(null,"one over");
					}
				},1000);
			},
			function(paramVal,done){
				var j=0;
				setInterval(function(){
					console.log("bbb"+paramVal+new Date());
					j++;
					if(j==3){
						clearInterval(this);
						done(null,paramVal+",two over");
					}
				},1000);
			}
		],
		function(err,re){
			console.log(err);
			console.log(re);
		}
	);
}
exec();
console.log("main finish");