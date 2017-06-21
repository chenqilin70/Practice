var http=require("http");
var url = require("url");
var router=require("./router");
http.createServer(function(request,response){
	var thisUrl=request.url;
	if(thisUrl!=="/favicon.ico"){
		response.writeHead(200,{"Content-Type":"text/html;charset=utf-8"})
		var pathname=url.parse(thisUrl).pathname.replace(/\//,"");
		console.log(pathname);
		router[pathname](request,response);
		response.end();
	}
}).listen(8000);
console.log("server is running")