var http=require("http");
var otherFun=require("./model/otherFun.js")
http.createServer(function(request,response){
	response.writeHead(200,{"Content-Type":"text/html;charset=utf-8"})
	if(request.url!=="/favicon.ico"){
		otherFun.fun2(response);
		otherFun.fun3(response);
		response.end();
	}
	
}).listen(8000);
console.log("Server is running");