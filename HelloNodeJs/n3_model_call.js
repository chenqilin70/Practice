var http=require("http");
//var User=require("./model/User.js")
var Teacher=require("./model/Teacher.js")
http.createServer(function(request,response){
	if(request.url!=="/favicon.ico"){
		response.writeHead(200,{"Content-Type":"text/html;charset=utf-8"})
		tea=new Teacher(1,"张三",20);
		tea.enter();
		tea.teach(response);
		response.end();
	}
}).listen(8000);
console.log("server is running")