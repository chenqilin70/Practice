<%@page import="com.mysql.shopping.model.bean.Goods" %>
<%@page import="java.util.ArrayList" %>
<%@page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>杰仔专卖网</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<!-- 下面这个是网页标题前面的图标设置语言 -->
<link rel="shortcut icon" type="image/x-icon" href="image/title.jpg" media="screen" />
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
<script src="js/responsiveslides.min.js"></script>
   <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
</head>
<body>
<!-- 这是引入的jsp文件的代码 -->
<%@include file="Head.jsp" %>
<div class="account">
	<div class="container">
		<h3 style=" text-align: center; margin-top: -40px">个人信息</h3>
		<div class="account_grid">
		<span>${requestScope.rebackupdate }</span>
	    	<div class="col-md-12 login-right">
				<form action="UserServlet?method=updateinfo" method="post" style="padding-left: 70px; margin-top: 50px" enctype="multipart/form-data">
					<div class="col-md-4 login-mid" >	
						<span><font size="4px">用户编号:<input style="width: 180px" value="${sessionScope.Loginuser.userID}" name="userid"></font></span><br /><br />
						<span><font size="4px">用户账号:<input style="width: 180px" value="${sessionScope.Loginuser.username }" name="username"></font></span><br /><br />
						<span><font size="4px">用户密码:<input style="width: 180px" value="${sessionScope.Loginuser.password }" name="password"></font></span><br /><br />
					  	<span><font size="4px">真实姓名:<input style="width: 180px" value="${sessionScope.Loginuser.realname }" name="realname"></font></span><br /><br />
					</div>
					<div class="col-md-4 login-mid">
						<span><font size="4px" >用户头像:</font></span><br/>
						<img  style="border: 1px solid gray;border-radius:100px;" src="${sessionScope.Loginuser.image }"  width="200" height="200"/>
						<input name="image" type="file" value="更换头像" style="float: right;" >
						<br/>
					</div>
					<div class="col-md-4 login-right">
						<span><font size="4px">用户性别:</font>
						<c:if test="${requestScope.user.sex eq 1}">
			<input style="width: 250px; height: 30px;background-color:transparent" value="男" name="sex">
			</c:if>
			<c:if test="${requestScope.user.sex ne 1}">
			<input style="width: 250px; height: 30px;background-color:transparent" value="女" name="sex">
			</c:if>
						</span>
						<br /><br />
						<span><font size="4px">用户年龄:<input style="width: 250px; height: 30px;background-color:transparent" value="${sessionScope.Loginuser.age }" name="age"></font></span>
						
						<br /><br />
						<input type="submit"  value="修改"  />
					</div>
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"  %>
</body>
</html>