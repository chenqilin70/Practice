<%@page import="com.mysql.shopping.model.bean.Goods" %>
<%@page import="java.util.ArrayList" %>
<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"
        isELIgnored="false" errorPage="404.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- 不经过登陆界面显示page指定为第一页，count加载多少条数据 -->
    <c:if test="${requestScope.gs eq null }" >
    	<!--标签通过重写url来将浏览器重新顶一个url  -->
    	<c:redirect url="GoodsServlet?method=listgoodsbypage&page=1&count=12" ></c:redirect>
    </c:if>
<!DOCTYPE html>
<html>
<head>
<title>杰仔专卖网-主页</title>
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
<script src="js/json.js"> </script>
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
<%@include file="Head.jsp" %>
<!--content-->
<div class="content" style="background-color: threeddarkshadow;">
	<div class="container">
		<div class="content-top">
			<h1>Recent Products</h1>
		<div class="col-md-12">
			<div class="content-top1" style="margin-top: -50px">
			<!-- 遍历从数据库查询出来的商品信息 -->
			<c:forEach var="G" items="${requestScope.gs }" >
				<div class="col-md-3 col-md3" style="margin-top:20px">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="GoodsServlet?method=listgooddetail&productid=${G.productid }" >
							<img class="img-responsive"  style="width: 209px; height: 280px; border: 2px solid gray; " src="${G.image }" alt="" />
						</a>
						<div style="position: relative;margin-top: -23px; margin-left: 5px">${G.brand }</div>
						<h3><a href="GoodsServlet?method=listgooddetail&productid=${G.productid }">${G.productid }</a>${G.description }</h3>
						<div class="price">
							<h5 class="item_price">${G.basicprice}</h5>
							<a href="GoodsServlet?method=listgooddetail&productid=${G.productid }" class="item_add">商品详情</a>
							<div class="clearfix" style="margin-top: 10px"> </div>
						</div>
					</div>
				</div>	
			</c:forEach>
			</div>	
			<div class="clearfix"> </div>
		</div>
		</div>
	</div>
</div>
<div style="text-align: center; margin-bottom: 20px">
	<a style="margin-top: 40px;" class="acount-btn" href="GoodsServlet?method=listgoodsbypage&page=${requestScope.page.firstpage}&count=${requestScope.page.count}">首页</a>&nbsp;&nbsp;
	<a style="margin-top: 40px;"  class="acount-btn" href="GoodsServlet?method=listgoodsbypage&page=${requestScope.page.prepage}&count=${requestScope.page.count}">上一页</a>&nbsp;&nbsp;
	<a style="margin-top: 40px;" class="acount-btn" href="GoodsServlet?method=listgoodsbypage&page=${requestScope.page.nextpage}&count=${requestScope.page.count}">下一页</a>&nbsp;&nbsp;
	<a style="margin-top: 40px;" class="acount-btn" href="GoodsServlet?method=listgoodsbypage&page=${requestScope.page.lastpage}&count=${requestScope.page.count}">尾页</a>&nbsp;&nbsp;
	<a style="margin-top: 40px;" class="acount-btn">当前第${requestScope.page.nowpage}页/总共${requestScope.page.lastpage}页</a> 
</div> 
<%@include file="footer.jsp" %>
</body>
</html>