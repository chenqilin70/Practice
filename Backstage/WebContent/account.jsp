<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8" isELIgnored="false" %>
<!-- 导入c标签 -->
<%--Taglib指令引入一个自定义标签集合的定义，包括库路径、自定义标签 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- EL表达式需要在page指令里面添加isELIgnored -->
<!DOCTYPE html>
<html>
<head>
<title>杰仔专卖网</title>
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
<!-- slide -->
</head>
<body>
<%@include file="Head.jsp" %>
<!--//header-->
<div class="account">
	<div class="container">
		<h1>Welcome to JieZai</h1>
		<div class="account_grid">
		<div class="col-md-6 login-right">
			<c:if test="${requestScope.errorMessage ne null }">
				<!-- el表达式只能是setAttribute里面的值 -->
				<span style="color:red">${requestScope.errorMessage}</span>
			</c:if>
			<!--这里表单执行是动作是判断在Userservlet里面传来的方法  -->
			<form action="UserServlet?method=login" method="post"> 
				<span>账号</span>
				<!--这里的EL表达式是能够在刷新该页面是能够保留之前的用户名和密码 -->
				<input type="text" name="username" style="background-color:transparent;width: 300px; height:35px" value="${cookie.username.value}"> 
				<span>密码</span>
				<input type="password" name="password" style="background-color:transparent;width: 300px; height:35px" value="${cookie.password.value}"> 
				<br />
				<!--判断是否记住密码  -->
				<c:if test="${cookie.password.value eq null }">
					<input type="checkbox" name="remmima" value="1" >记住密码
				</c:if>
				<c:if test="${cookie.password.value ne null }">
					<input type="checkbox" name="remmima" checked="checked" value="1" >记住密码
				</c:if>
				<span>验证码</span>
				<input type="text" name="code" style="background-color:transparent;width: 210px; height:35px; ">
				<img src="CodeServlet"  style="width:85px ;height:35px;border: 1px solid gray">
				<font size="3px"><a href="account.jsp">看不清？换一张</a></font>
				<div class="word-in">
				  	<a class="forgot" href="#">忘记密码？</a>
			     	<input type="submit" value="登陆">
				</div>
			</form>
		</div>	
			    
		<div class="col-md-6 login-left">
			<h4>NEW CUSTOMERS</h4>
			<p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
			<a class="acount-btn" href="register.jsp">Create an Account</a>
		</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>