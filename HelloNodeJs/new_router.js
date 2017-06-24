var fileread=require("./model/new_fileread");
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
var Router=function(resp){
	this.recall=recall.bind(resp);
	this.imgRecall=imageRecall.bind(resp);
}
Router.prototype.login=function(){
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
module.exports=Router;
