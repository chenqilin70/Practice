var http=require("http");
var url=require("url");
var router=require("./new_router")
http.createServer(function(request,response){
	var thisUrl=request.url;
	if(thisUrl!="/favicon.ico"){
		response.writeHead(200,{"Content-Type":"text/html;charset=utf-8"});
		var funcName=url.parse(thisUrl).pathname.replace(/\//,"");
		router[funcName](response);
	}
}).listen(8000);
console.log("server is running")