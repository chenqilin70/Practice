var fs=require('fs');
module.exports={
	readFileSync:function(){
		console.log("同步读取方法暂不提供")
	},
	readFile:function(path,recall){
		fs.readFile(path,function(err,data){
			if(err){
				console.log(err)
				recall("文件读取失败！！");
			}else{
				recall(data);	
			}

		})
	},
	writeFile:function(path,data,recall){
		fs.writeFile(path,data,function(err){
			if(err){
				throw err;
				recall("文件写入失败！！");
			}else{
				recall("写文件成功！！");
			}
		})
	},
	readImage:function(path,recall){
		fs.readFile(path,'binary',function(err,fileData){
			if(err){
				throw err;
				recall("图片读取失败");
			}else{
				recall(fileData);
			}

		})
	}
}