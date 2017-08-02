<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电商后台 -登陆页面</title>
<meta name="Copyright" content="Douco Design." />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/global.js"></script>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">
<link href="css/index_style.css" rel="stylesheet" type="text/css">
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<script>
//宇宙特效
"use strict";
var canvas = document.getElementById('canvas'),
  ctx = canvas.getContext('2d'),
  w = canvas.width = window.innerWidth,
  h = canvas.height = window.innerHeight,

  hue = 217,
  stars = [],
  count = 0,
  maxStars = 1300;//星星数量

var canvas2 = document.createElement('canvas'),
  ctx2 = canvas2.getContext('2d');
canvas2.width = 100;
canvas2.height = 100;
var half = canvas2.width / 2,
  gradient2 = ctx2.createRadialGradient(half, half, 0, half, half, half);
gradient2.addColorStop(0.025, '#CCC');
gradient2.addColorStop(0.1, 'hsl(' + hue + ', 61%, 33%)');
gradient2.addColorStop(0.25, 'hsl(' + hue + ', 64%, 6%)');
gradient2.addColorStop(1, 'transparent');

ctx2.fillStyle = gradient2;
ctx2.beginPath();
ctx2.arc(half, half, half, 0, Math.PI * 2);
ctx2.fill();

// End cache

function random(min, max) {
  if (arguments.length < 2) {
    max = min;
    min = 0;
  }

  if (min > max) {
    var hold = max;
    max = min;
    min = hold;
  }

  return Math.floor(Math.random() * (max - min + 1)) + min;
}

function maxOrbit(x, y) {
  var max = Math.max(x, y),
    diameter = Math.round(Math.sqrt(max * max + max * max));
  return diameter / 2;
  //星星移动范围，值越大范围越小，
}

var Star = function() {

  this.orbitRadius = random(maxOrbit(w, h));
  this.radius = random(60, this.orbitRadius) / 8; 
  //星星大小
  this.orbitX = w / 2;
  this.orbitY = h / 2;
  this.timePassed = random(0, maxStars);
  this.speed = random(this.orbitRadius) / 50000; 
  //星星移动速度
  this.alpha = random(2, 10) / 10;

  count++;
  stars[count] = this;
}

Star.prototype.draw = function() {
  var x = Math.sin(this.timePassed) * this.orbitRadius + this.orbitX,
    y = Math.cos(this.timePassed) * this.orbitRadius + this.orbitY,
    twinkle = random(10);

  if (twinkle === 1 && this.alpha > 0) {
    this.alpha -= 0.05;
  } else if (twinkle === 2 && this.alpha < 1) {
    this.alpha += 0.05;
  }

  ctx.globalAlpha = this.alpha;
  ctx.drawImage(canvas2, x - this.radius / 2, y - this.radius / 2, this.radius, this.radius);
  this.timePassed += this.speed;
}

for (var i = 0; i < maxStars; i++) {
  new Star();
}

function animation() {
  ctx.globalCompositeOperation = 'source-over';
  ctx.globalAlpha = 0.5; //尾巴
  ctx.fillStyle = 'hsla(' + hue + ', 64%, 6%, 2)';
  ctx.fillRect(0, 0, w, h)

  ctx.globalCompositeOperation = 'lighter';
  for (var i = 1, l = stars.length; i < l; i++) {
    stars[i].draw();
  };

  window.requestAnimationFrame(animation);
}

animation();
</script>
 <script type="text/javascript">
  
    $(function() {
    	  $("#codeCheck").change(function() {
    		    var ajax = createAJAX();
    		    var checkcode = this.value;
    	        var method = "POST";
    	        var url = "${pageContext.request.contextPath}/checkRequest!check.action?time="+new Date().getTime();
    	        ajax.open(method,url);
    	        //设置请求头（必须）
    	        ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");

    	        var content = "checkcode=" + checkcode;
    	        ajax.send(content);

    	        ajax.onreadystatechange = function(){
    	        	if(ajax.readyState == 4){
    	                if(ajax.status == 200){
    	                    var tip = ajax.responseText;
    	                    //alert(tip);
    	                  if(tip=="success"){
    	                	/*  var img = document.createElement("img");
    	                     img.src = tip;
    	                     //定位验证码文本框
    	                     var td = document.getElementById("tishi");
    	                     td.innerHTML = "验证码正确"; */
    	                     $("#tishi").html("<font color='green'>验证码正确</font>");
    	                     }else {
    	          		       /*  var td = document.getElementById("tishi");
    	         		        td.innerHTML = "验证码错误";
    	         		        td.appendChild(img);
    	         		        var t = document.getElementById("code");
    	         		        t.innerHTML = ""; */
    	         		        $("#tishi").html("<font color='red'>验证码错误</font>");
    	         		        $("#codeCheck").val("");
    	         		        
    	                  
    	                }
    	            }
    	    }
    	        };
    	  });
	 });
</script> 
 <script type="text/javascript">
 
 
function huan(x)
{
	x.src="code.jsp?time"+new Date();
}

function createAJAX(){
	var ajax = null;
	try{
	ajax = new ActiveXObject("microsoft.xmlhttp");
	}catch(e1){
	try{
	ajax = new XMLHttpRequest();
	}catch(e2){
	alert("你的浏览器不支持ajax，请更换浏览器");
	}
	}
	return ajax;
	}

</script>



</head>
<body>
<div class="header" id="demo">
    	
    
  <div class="canvaszz"> 
  <div class="title" align="center" style="margin-top: 100px;">
  <form method="post"  action="UserActionyc!login.action" >
			<font size="6px" style="color: white">管理登录</font><br /><br /><br />
			<label for="input1"><font size="3px" style="color: white">用户账号</font></label> <input type="text"
							name="user.username" id="input1" /><br /><br /><br />
			<label for="input2"><font size="3px" style="color: white">账户密码</font></label> <input type="password"
							name="user.password" id="input2" /><br /><br /><br />
			<label for="code"><font size="3px" style="color: white;margin-left: 125px;">验证码</font></label> <input type="text"
								style="width: 120px;" name="code" id="codeCheck" maxlength="6"  />	
			<img id="safecode" onclick="huan(this)" alt="点击换一张" title="点击换一张" src="code.jsp" style="width: 120px;height: 25px;margin-left: 5px;position: relative;top: 5px;"/>	<br /><br /><br />				
			<input type="submit" value="登陆" style="width: 100px;margin-left: 60px;" />
					</form>		
	       </div>
  </div>
  <canvas id="canvas"></canvas> 
</div>




</div>
<script>
//宇宙特效
"use strict";
var canvas = document.getElementById('canvas'),
  ctx = canvas.getContext('2d'),
  w = canvas.width = window.innerWidth,
  h = canvas.height = window.innerHeight,

  hue = 217,
  stars = [],
  count = 0,
  maxStars = 1300;//星星数量

var canvas2 = document.createElement('canvas'),
  ctx2 = canvas2.getContext('2d');
canvas2.width = 100;
canvas2.height = 100;
var half = canvas2.width / 2,
  gradient2 = ctx2.createRadialGradient(half, half, 0, half, half, half);
gradient2.addColorStop(0.025, '#CCC');
gradient2.addColorStop(0.1, 'hsl(' + hue + ', 61%, 33%)');
gradient2.addColorStop(0.25, 'hsl(' + hue + ', 64%, 6%)');
gradient2.addColorStop(1, 'transparent');

ctx2.fillStyle = gradient2;
ctx2.beginPath();
ctx2.arc(half, half, half, 0, Math.PI * 2);
ctx2.fill();

// End cache

function random(min, max) {
  if (arguments.length < 2) {
    max = min;
    min = 0;
  }

  if (min > max) {
    var hold = max;
    max = min;
    min = hold;
  }

  return Math.floor(Math.random() * (max - min + 1)) + min;
}

function maxOrbit(x, y) {
  var max = Math.max(x, y),
    diameter = Math.round(Math.sqrt(max * max + max * max));
  return diameter / 2;
  //星星移动范围，值越大范围越小，
}

var Star = function() {

  this.orbitRadius = random(maxOrbit(w, h));
  this.radius = random(60, this.orbitRadius) / 8; 
  //星星大小
  this.orbitX = w / 2;
  this.orbitY = h / 2;
  this.timePassed = random(0, maxStars);
  this.speed = random(this.orbitRadius) / 50000; 
  //星星移动速度
  this.alpha = random(2, 10) / 10;

  count++;
  stars[count] = this;
}

Star.prototype.draw = function() {
  var x = Math.sin(this.timePassed) * this.orbitRadius + this.orbitX,
    y = Math.cos(this.timePassed) * this.orbitRadius + this.orbitY,
    twinkle = random(10);

  if (twinkle === 1 && this.alpha > 0) {
    this.alpha -= 0.05;
  } else if (twinkle === 2 && this.alpha < 1) {
    this.alpha += 0.05;
  }

  ctx.globalAlpha = this.alpha;
  ctx.drawImage(canvas2, x - this.radius / 2, y - this.radius / 2, this.radius, this.radius);
  this.timePassed += this.speed;
}

for (var i = 0; i < maxStars; i++) {
  new Star();
}

function animation() {
  ctx.globalCompositeOperation = 'source-over';
  ctx.globalAlpha = 0.5; //尾巴
  ctx.fillStyle = 'hsla(' + hue + ', 64%, 6%, 2)';
  ctx.fillRect(0, 0, w, h)

  ctx.globalCompositeOperation = 'lighter';
  for (var i = 1, l = stars.length; i < l; i++) {
    stars[i].draw();
  };

  window.requestAnimationFrame(animation);
}

animation();
</script>
 <script type="text/javascript">
  
    $(function() {
    	  $("#codeCheck").change(function() {
    		    var ajax = createAJAX();
    		    var checkcode = this.value;
    	        var method = "POST";
    	        var url = "${pageContext.request.contextPath}/checkRequest!check.action?time="+new Date().getTime();
    	        ajax.open(method,url);
    	        //设置请求头（必须）
    	        ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");

    	        var content = "checkcode=" + checkcode;
    	        ajax.send(content);

    	        ajax.onreadystatechange = function(){
    	        	if(ajax.readyState == 4){
    	                if(ajax.status == 200){
    	                    var tip = ajax.responseText;
    	                    //alert(tip);
    	                  if(tip=="success"){
    	                	/*  var img = document.createElement("img");
    	                     img.src = tip;
    	                     //定位验证码文本框
    	                     var td = document.getElementById("tishi");
    	                     td.innerHTML = "验证码正确"; */
    	                     $("#tishi").html("<font color='green'>验证码正确</font>");
    	                     }else {
    	          		       /*  var td = document.getElementById("tishi");
    	         		        td.innerHTML = "验证码错误";
    	         		        td.appendChild(img);
    	         		        var t = document.getElementById("code");
    	         		        t.innerHTML = ""; */
    	         		        $("#tishi").html("<font color='red'>验证码错误</font>");
    	         		        $("#codeCheck").val("");
    	         		        
    	                  
    	                }
    	            }
    	    }
    	        };
    	  });
	 });
</script> 
 <script type="text/javascript">
 
 
function huan(x)
{
	x.src="code.jsp?time"+new Date();
}

function createAJAX(){
	var ajax = null;
	try{
	ajax = new ActiveXObject("microsoft.xmlhttp");
	}catch(e1){
	try{
	ajax = new XMLHttpRequest();
	}catch(e2){
	alert("你的浏览器不支持ajax，请更换浏览器");
	}
	}
	return ajax;
	}

</script>
</body>
</html>