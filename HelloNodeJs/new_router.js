var fileread=require("./model/new_fileread");
function recall(data){
	this.write(data);
	this.end();
}
var Router=function(resp){
	this.recall=recall.bind(resp);
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
module.exports=Router;
