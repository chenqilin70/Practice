var fs=require('fs');
module.exports={
	readFileSync:function(){
		console.log("同步方法暂不提供")
	},
	readFile:function(path,recall){
		fs.readFile(path,function(err,data){
			if(err){
				console.log(err)
			}else{
				recall(data);	
			}

		})
	}
}