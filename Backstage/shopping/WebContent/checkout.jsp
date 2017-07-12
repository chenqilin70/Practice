<%@page import="com.mysql.shopping.model.bean.Goods"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8" isELIgnored="false" %>
 <%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>杰仔专卖网</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!-- 下面这个是网页标题前面的图标设置语言 -->
<link rel="shortcut icon" type="image/x-icon" href="image/title.jpg" media="screen" />
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
<style type="text/css">
.gouwuche1{ width: 20%; font-size: 20px ;color: white}
.gouwuche2{ width: 20%; font-size: 20px ;color: white}
.gouwuche { width: 15%; font-size: 20px ;color: white}
</style>
<script type="text/javascript">
function  deleteProduct(id){
	var  result=confirm('确认删除吗?亲');
	if(result)
	{
		window.location.href='GoodsServlet?method=deleteProduct&productid='+id;
	}
}
</script>
</head>
<body>
<%@include file="Head.jsp" %>
<div class="container">
	<div class="check-out" style="margin-top: 10px;">
    		<table style=" border: 1px solid black; margin-top: -20px; text-align: center; size: 20px" >
		 		<tr>
					<td class="gouwuche1">物品栏</td>
					<td class="gouwuche2">商品信息</td>
					<td class="gouwuche">单价</td>
					<td class="gouwuche">数量</td>		
					<td class="gouwuche">金额</td>  
					<td class="gouwuche">操作</td>
		  		</tr>
		  		<c:forEach var="m" items="${sessionScope.shoppingcar}">
		  		<tr style=" border: 1px solid black; " >
					<td class="ring-in" style=" border: 1px solid black; width: 25%">
						<a href="single.jsp" class="at-in"><img src="${m.key.image }" class="img-responsive" alt="" style="width: 60px; height: 60px"></a>
						<div class="sed" >
							<p>${m.key.productid} ${m.key.description }</p>
						</div>
						<div class="clearfix"> </div>
					</td>
					<td><p>${m.key.name}:${m.key.description }</p></td>
					<td><fmt:formatNumber value="${m.key.basicprice}" pattern="￥0.00"></fmt:formatNumber></td>
					<td>${m.value }</td>		
					<td><fmt:formatNumber value="${m.key.basicprice*m.value}" pattern="￥0.00"></fmt:formatNumber></td>
					<td><a href="javascript:deleteProduct(${m.key.productid})">删除</a></td>
		  		</tr>
		  		</c:forEach>
			</table>
		<a href="UserServlet?method=getdetailinfo&userID=${sessionScope.Loginuser.userID }&editOrder=true" class=" to-buy">生成订单</a>
		<div class="clearfix"></div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>