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
  </head>
<body>
	<%@include file="Head.jsp" %>
	<div id="order" style="width: 100%;" align="center">
		<table style="width: 80%; border: 5px solid black; margin-top: 70px" align="center" >
			<tr>
				<td colspan="6" class="ordergood" style="border: 1px solid black">商品订单详情：</td>
			</tr>
			<tr>
				<td class="gouwuche1">物品栏</td>
				<td class="gouwuche2">商品信息</td>
				<td class="gouwuche">单价</td>
				<td class="gouwuche">数量</td>		
				<td class="gouwuche">金额</td>  
			  	</tr>
		  	<c:forEach var="m" items="${sessionScope.shoppingcar}">
		  		<tr style=" border: 1px solid black; " >
					<td class="ring-in" style=" border: 1px solid black; width: 25%">
						<a href="single.jsp" class="at-in"><img src="${m.key.image }" class="img-responsive" alt="" style="width: 60px; height: 60px"></a>
						<div class="sed" >
							<p>${m.key.description }</p>
						</div>
						<div class="clearfix"> </div>
					</td>
					<td><p>${m.key.name}:${m.key.description }</p></td>
					<td><fmt:formatNumber value="${m.key.basicprice}" pattern="￥0.00"></fmt:formatNumber></td>
					<td>${m.value}</td>		
					<td><fmt:formatNumber value="${m.key.basicprice*m.value}" pattern="￥0.00"></fmt:formatNumber></td>
		  		</tr>
		  	</c:forEach>
		  	<tr style="border: 1px solid black">
		  		<td colspan="6" align="right" class="ordergood">总计：${sessionScope.total }</td>
		  	</tr>
		  	<tr style="border: 1px solid black">
		  		<td style="width: 20%;border: 1px solid black">收货地址：</td>
		  		<td><c:forEach var="a"  items="${requestScope.user.adds }">
		  			<select id="address">
		 				<option value="${a.addressId }">${a.province}&nbsp;${a.city}&nbsp;${a.area}&nbsp;${a.street}&nbsp;${a.user}&nbsp;联系电话：${a.tel }</option>
					</select>
					</c:forEach>
				</td>
		  	</tr>
		  	<tr style="border: 1px solid black">
		  		<td style="width: 20%;border: 1px solid black">买家留言：</td>
		  		<td ><input type="text" style="width: 100%" name="message" value="${param.message}"></td>
		  	</tr>
		  	<tr><td colspan="6" align="center"><a href="javascript:window.location.href='OrderServlet?method=addgoodslist&addressid='+document.getElementById('address').value" ><input type="submit"  value="立即购买"  /></a></td></tr>
		</table>
		<%@include file="footer.jsp" %>
	</div>

</body>
</html>
