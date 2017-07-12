<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
</head>
<body>
<%@include file="Head.jsp" %>
<div class="container">
	<div class="register">
		<h1>注册账号</h1>
		<% if(request.getAttribute("Message")!=null){ %>
			  	<span style="color:red"><%=request.getAttribute("Message") %></span>
			  	<%} %>
			  	<!-- 再点击表单提交之后，	跳转到UserServlet的注册方法里 -->
		<form action="UserServlet?method=register" method="post" > 
			<div class="col-md-6  register-top-grid">
			<!-- 注册界面需要连接到数据库 -->
				<div class="mation">
					<!--为了能让后端数据库渠道相应的值，应该要将内阁表单后面加上name属性  -->
					<span>用户名</span>
					<input type="text" name="username"> 
					<span>真实姓名</span>
					
					<input type="text" name="realname"> 
					<span>年龄</span><!-- //尽量把name写死，防止不可避免的事情 -->
						
					<select name="age">
						<% for(int n=14;n<=100;n++)
						{%>
							<option value="<%=n%>"><%=n%></option>
						<%} %>
					</select>
						
					<input type="hidden" name="status" value="0" /><!-- 隐藏不希望用户看到的需要传到数据库的值 -->
						
					<span>性别</span>
					<input type="radio" name="sex" value="0">男<input type="radio" name="sex" value="1">女
				</div>
					 
			    <div class="clearfix"> </div>
					<a class="news-letter" href="#">
					<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>记住密码</label>
					</a>
				</div>
				     
				<div class=" col-md-6 register-bottom-grid">
					<div class="mation">
						<span>密码</span>
						<input type="text" name="password">
						<span>确认密码</span>
						<input type="text">
						<input type="hidden" name="status"/ >
						<input type="submit" value="submit">
		   				 <!-- 提交之后会 的下一步会跳转到哪里 -->>
					</div>
				</div>
		</form>
</div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>