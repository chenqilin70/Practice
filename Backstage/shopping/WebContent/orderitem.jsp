<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib  prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
  <style type="text/css">
  .ordergood{ font-size: 20px; color:white}
  </style>
 <style type="text/css">
  td{ width: 50%}
 </style>
 </head>
<body>
	<%@include file="Head.jsp" %>
	<div align="center" style="margin-top: 30px"><h2>订单详情</h2></div>
	<div id="order" style="width: 100%; margin-top: -20px" align="center">
	<c:forEach var="o" items="${requestScope.os}">
	<table style="width: 60%; border: 3px solid gray; margin-top: 70px" align="center">
		<tr style="border: 1px solid gray">
			<td colspan="2">收货地址:${o.add.province}&nbsp;${o.add.city}&nbsp;${o.add.area}&nbsp;${o.add.street}&nbsp;${o.add.user}&nbsp;${o.add.tel }&nbsp;${o.add.detail }</td>
		</tr>
		<tr style="border: 1px solid gray">
			<td>收货人：${sessionScope.Loginuser.realname }</td>
			<td>联系电话：${o.add.tel}</td>
		</tr>
		<tr style="border: 1px solid gray">
			<td>订单编号：${o.orderid}</td>
			<td>付款时间：${o.time}</td>
		</tr>
		<tr style="border: 1px solid gray">
			<td>商品信息：
				<c:forEach var="m" items="${sessionScope.shoppingcar}">
		  			<img src="${m.key.image }" style="width: 50px; height: 60px">${m.key.description }${m.value}<font>件</font>
		  		</c:forEach>
			</td>
			<td>创建时间：${o.time}</td>
		</tr>
		<tr style="border: 1px solid gray">
			<td>商品总价：${sessionScope.total }</td>
			<td>发货时间：${o.time}</td>
		</tr>
	</table>
	</c:forEach>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>
