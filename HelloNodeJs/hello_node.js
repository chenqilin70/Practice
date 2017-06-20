var http=require('http');
http.createServer(function(request,response){
	response.writeHead(200,{
		"Content-Type":"text/html;charset=utf-8"
	});
	console.log(request.url);
	if(request.url!=="/favicon.ico"){
		console.log("\u8bbf\u95ee");
		response.write("hello,world!!!!!\u8bbf\u95ee");
		response.end();
	}
	
}).listen(8000);
console.log("Server is running at 8000")