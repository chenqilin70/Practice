var Man=function(name){
	this.name=name;
	this.newreCall=showAge.bind(this)
}
function showAge(){
	console.log(this)
}
Man.prototype.showName=function(){
	mainFun(this.newreCall);
}
function mainFun(recall){
	recall();
}
new Man("KYLIN")['showName']();