var fileread=require("./model/new_fileread");
var URL=require("url");
var querystring=require('querystring');
function recall(data){
	this.writeHead(200,{"Content-Type":"text/html;charset=utf-8"});
	this.write(data);
	this.end();
}
function imageRecall(fileData){
	this.writeHead(200,{"Content-Type":"image/jpeg"});
	this.write(fileData,'binary')
	this.end();
}
var Router=function(req,resp){
	this.req=req;
	this.resp=resp;
	this.recall=recall.bind(this.resp);
	this.imgRecall=imageRecall.bind(this.resp);
}
Router.prototype.login=function(){
	var params=URL.parse(this.req.url,true).query;
	//get接受参数的方法↓
	//console.log(URL.parse(this.req.url,true));
	fileread.readFile("./views/login.html",this.recall);
}
Router.prototype.register=function(){
	fileread.readFile("./views/register.html",this.recall);
}
Router.prototype.writefile=function(){
	fileread.writeFile("./uploadFile/"+new Date().getTime()+".txt",new Date().getTime()+"yishangshiyaoxierudewenben ",this.recall)
}
Router.prototype.readImg=function(){
	fileread.readImage("./img/default.jpg",this.imgRecall)
}
Router.prototype.showImg=function(){
	fileread.readImage("./img/default.jpg",this.imgRecall)
}
Router.prototype.error=function(err){
	this.recall(err.toString())
}
Router.prototype.postParamReciver=function(){
	var resp=this.resp;
	//post接受参数的方法↓
	var post='';
	this.req.on("data",function(chunk){//此方法异步
		for(var i=0;i<20000;i++){
			console.log(11111)
		}
		post+=chunk;
	});
	this.req.on("end",function(){//此方法异步
		console.log("2222222222222222222222222222222222222222222222222222222")
		post=querystring.parse(post);
		console.log("收到的参数："+post['email']+"\t"+post['password']);
		resp.write("收到的参数："+post['email']+"\t"+post['password']);
		resp.end();
	})
}
module.exports=Router;
