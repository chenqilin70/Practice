var fileread=require("./model/new_fileread");
function recall(data){
	this.write(data);
	this.end();
}
module.exports={
	login:function(resp){
		var readyRecall=recall.bind(resp)
		fileread.readFile("./views/login.html",readyRecall);
	},
	register:function(resp){
		var readyRecall=recall.bind(resp)
		fileread.readFile("./views/register.html",readyRecall);
	}
}