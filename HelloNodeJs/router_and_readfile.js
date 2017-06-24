var http=require("http");
var url=require("url");
var Router=require("./new_router")
http.createServer(function(request,response){
	var thisUrl=request.url;
	if(thisUrl!="/favicon.ico"){
		var funcName=url.parse(thisUrl).pathname.replace(/\//,"");
		new Router(response)[funcName]();
	}
}).listen(8000);
console.log("server is running")