function exceptionFun(data){
	if(data==0){
		throw "data cant be 0";
	}else{
		console.log("result is "+(10/data))
	}
}
try{
	exceptionFun(0);
}catch(err){
	console.log("erro is "+err)
}