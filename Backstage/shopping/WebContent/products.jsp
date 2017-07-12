<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.shopping.model.bean.Goods"%>
<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>杰仔专卖网</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
</head>
<script>
	$(window).scroll(function(){
		var scrollTop = $(this).scrollTop();
		var scrollHeight = $(document).height();
		var windowHeight = $(this).height();
		if(scrollTop + windowHeight >= scrollHeight){
			alert("已经到最底部了");
			var url="GoodsServlet?method=searchGoods&ajax=true&page="+$("#nextpage").val()+"&key="+$("#key").val()+"&count="+6;
			//获取返回的数据
			$.get(url,function(data){
				for(var  x=0;x<data.length;x++)
				{
					alert("正在加载数据");
					var newGoodsInfo="<div class='col-md-4 col-md3' style='margin-top: 20px'><div class='col-md1 simpleCart_shelfItem'><a href='GoodsServlet?method=listgooddetail&productid="+data[x].productid+"'><img style='width: 209px; height: 300px; border: 2px solid black;' src='"+data[x].image+"' alt='' /></a><div style='position: relative;margin-top: -23px; margin-left: 5px'>"+data[x].brand+"</div><h3><a href='GoodsServlet?method=listgooddetail&productid"+data[x].productid+"'>"+data[x].productid+"</a></h3><div class='price'><h5 class='item_price'>"+data[x].basicprice+"</h5><a href='GoodsServlet?method=listgooddetail&productid="+data[x].productid+"' class='item_add'>商品详情</a><div class='clearfix' style='margin-top: 30px'></div></div></div></div>"
					alert("已经加载出来了")
					$("#allProduct").append(newGoodsInfo);
				}
				$("#nextpage").val(parseInt($("#nextpage").val())+1);
			});
		}
	});
</script>
<body>
<input type="hidden"  id="nextpage" value="${requestScope.page.nextpage }"> 
<input type="hidden"  id="count" value=6> 
<input type="hidden"  id="key" value="${sessionScope.key}"> 
<%@include file="Head.jsp" %>
<div class="products">
	<div class="container">
		<h1>Welcome to ShoppingMark</h1>
		<div class="col-md-9">
			<div class="content-top1" id="allProduct">
				<c:forEach var="G" items="${requestScope.gs }">
				<div class="col-md-4 col-md3" style="margin-top: 20px">
					<div class="col-md1 simpleCart_shelfItem">
						<!-- 从页面传过来的商品id来查询详细的商品信息 -->
						<a href="GoodsServlet?method=listgooddetail&productid=${G.productid }">
							<img style="width: 209px; height: 300px; border: 2px solid black;" src="${G.image }" alt="" />
						</a>
							<div style="position: relative;margin-top: -23px; margin-left: 5px">${G.brand }</div>
						<h3><a href="GoodsServlet?method=listgooddetail&productid${G.productid }"></a>${G.productid }</h3>
						<div class="price">
						
								<h5 class="item_price">${G.basicprice }</h5>
									<a href="GoodsServlet?method=listgooddetail&productid=${G.productid }" class="item_add">商品详情</a>
								<div class="clearfix" style="margin-top: 30px"> </div>
						</div>
					</div>
				</div>	
				</c:forEach>
			<div class="clearfix"> </div>
			</div>	
		</div>
		
		<div class="col-md-3 product-bottom">
			<!--categories-->
				<div class=" rsidebar span_1_of_left">
						<h3 class="cate">Categories</h3>
							 <ul class="menu-drop">
							<li class="item1"><a href="#">Men </a>
								<ul class="cute">
									<li class="subitem1"><a href="single.jsp">Cute Kittens </a></li>
									<li class="subitem2"><a href="single.jsp">Strange Stuff </a></li>
									<li class="subitem3"><a href="single.jsp">Automatic Fails </a></li>
								</ul>
							</li>
							<li class="item2"><a href="#">Women </a>
								<ul class="cute">
									<li class="subitem1"><a href="single.jsp">Cute Kittens </a></li>
									<li class="subitem2"><a href="single.jsp">Strange Stuff </a></li>
									<li class="subitem3"><a href="single.jsp">Automatic Fails </a></li>
								</ul>
							</li>
							<li class="item3"><a href="#">Kids</a>
								<ul class="cute">
									<li class="subitem1"><a href="single.jsp">Cute Kittens </a></li>
									<li class="subitem2"><a href="single.jsp">Strange Stuff </a></li>
									<li class="subitem3"><a href="single.jsp">Automatic Fails</a></li>
								</ul>
							</li>
							<li class="item4"><a href="#">Accesories</a>
								<ul class="cute">
									<li class="subitem1"><a href="single.jsp">Cute Kittens </a></li>
									<li class="subitem2"><a href="single.jsp">Strange Stuff </a></li>
									<li class="subitem3"><a href="single.jsp">Automatic Fails</a></li>
								</ul>
							</li>
									
							<li class="item4"><a href="#">Shoes</a>
								<ul class="cute">
									<li class="subitem1"><a href="product.jsp">Cute Kittens </a></li>
									<li class="subitem2"><a href="product.jsp">Strange Stuff </a></li>
									<li class="subitem3"><a href="product.jsp">Automatic Fails </a></li>
								</ul>
							</li>
						</ul>
					</div>
				<!--initiate accordion-->
						<script type="text/javascript">
							$(function() {
							    var menu_ul = $('.menu-drop > li > ul'),
							           menu_a  = $('.menu-drop > li > a');
							    menu_ul.hide();
							    menu_a.click(function(e) {
							        e.preventDefault();
							        if(!$(this).hasClass('active')) {
							            menu_a.removeClass('active');
							            menu_ul.filter(':visible').slideUp('normal');
							            $(this).addClass('active').next().stop(true,true).slideDown('normal');
							        } else {
							            $(this).removeClass('active');
							            $(this).next().stop(true,true).slideUp('normal');
							        }
							    });
							
							});
						</script>
				<div class="product-bottom">
						<h3 class="cate">Best Sellers</h3>
					<div class="product-go">
						<div class=" fashion-grid">
							<a href="single.jsp"><img class="img-responsive " src="images/pr.jpg" alt=""></a>	
						</div>
						<div class=" fashion-grid1">
							<h6 class="best2"><a href="single.jsp" >Lorem ipsum dolor sitamet consectetuer  </a></h6>
							<span class=" price-in1"> $40.00</span>
						</div>	
						<div class="clearfix"> </div>
					</div>
					<div class="product-go">
						<div class=" fashion-grid">
							<a href="single.jsp"><img class="img-responsive " src="images/pr1.jpg" alt=""></a>	
						</div>
						<div class=" fashion-grid1">
							<h6 class="best2"><a href="single.jsp" >Lorem ipsum dolor sitamet consectetuer  </a></h6>
							<span class=" price-in1"> $40.00</span>
						</div>	
						<div class="clearfix"> </div>
					</div>
					<div class="product-go">
						<div class=" fashion-grid">
							<a href="single.jsp"><img class="img-responsive " src="images/pr2.jpg" alt=""></a>	
						</div>
						<div class=" fashion-grid1">
							<h6 class="best2"><a href="single.jsp" >Lorem ipsum dolor sitamet consectetuer  </a></h6>
							<span class=" price-in1"> $40.00</span>
						</div>	
						<div class="clearfix"> </div>
					</div>	
					<div class="product-go">
						<div class=" fashion-grid">
							<a href="single.jsp"><img class="img-responsive " src="images/pr3.jpg" alt=""></a>	
						</div>
						<div class=" fashion-grid1">
							<h6 class="best2"><a href="single.jsp" >Lorem ipsum dolor sitamet consectetuer  </a></h6>
							<span class=" price-in1"> $40.00</span>
						</div>	
						<div class="clearfix"> </div>
					</div>		
				</div>

				<div class="tag">	
						<h3 class="cate">Tags</h3>
					<div class="tags">
						<ul>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>
						</ul>
					</div>					
				</div>
		</div>
		<div class="clearfix"></div>
		<p style="text-align: center;" id="jiazai">正在疯狂加载中...</p>
		<%-- <div style="text-align: center; margin-bottom: 20px">
			<a style="margin-top: 40px;" class="acount-btn" href="GoodsServlet?method=searchGoods&key=${key }&page=${requestScope.page.firstpage }&count=6" >首页</a>&nbsp;&nbsp;
			<a style="margin-top: 40px;" class="acount-btn" href="GoodsServlet?method=searchGoods&key=${key }&page=${requestScope.page.prepage }&count=6">上一页</a>&nbsp;&nbsp;
			<a style="margin-top: 40px;" class="acount-btn" href="GoodsServlet?method=searchGoods&key=${key }&page=${requestScope.page.nextpage }&count=6">下一页</a>&nbsp;&nbsp;
			<a style="margin-top: 40px;" class="acount-btn" href="GoodsServlet?method=searchGoods&key=${key }&page=${requestScope.page.lastpage }&count=6">尾页</a>&nbsp;&nbsp;
			<a style="margin-top: 40px;" class="acount-btn">当前第${requestScope.page.nowpage }页/总共${requestScope.page.lastpage }页</a> 
		</div>   --%>
	</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>