var http=require("http");
var optfile=require("./model/optfile")
http.createServer(function(request,response){
	var thisUrl=request.url;
	if(thisUrl!=="/favicon.ico"){
		response.writeHead(200,{"Content-Type":"text/html;charset=utf-8"})
		function recall(data){
			response.write(data);
			response.end();
		}
		optfile.readfile("./views/login.html",recall)
		
		console.log("main file is over")
	}
}).listen(8000);
console.log("server is running")