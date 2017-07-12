<%@page import="com.mysql.shopping.model.bean.User"%>
<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"
        isELIgnored="false" errorPage="404.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>头部文件</title>
<script>
	function searchGoods(url)
	{
		//获取input、的参数
		var key=document.getElementById("key").value;
		window.location.href=url+key+"&page=1&count=6";
	}
	function ajaxSearch()
	{
		var  key=document.getElementById("key").value;
		//1.创建一个xmlhttprequest对象
		var  xhr;
		//2.包括主流的浏览器和ie5和ie6等老版本的浏览器
		if(window.ActiveXObject){
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}else if(window.XMLHttpRequest){
			xhr = new XMLHttpRequest();
		}else{
			alert("不能创建xhr对象");
		}
		//3.添加响应事件，5种状态
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4)
			{
				if(xhr.status==200)
				{
					var  result=xhr.responseXML;//定义一个获取来自服务器的返回值
					var  pipeitable=document.getElementById("pipei");
					var  names=result.getElementsByTagName("name");
					var  code="";
						for(var  x=0;x<names.length;x++)
						{
							code+="<tr onclick=showSelectedData('"+names[x].firstChild.nodeValue+"') style='cursor:pointer; height:20px;padding:0px;' onmouseover=this.style.backgroundColor='#eeeeee' onmouseout=this.style.backgroundColor='white'><td style='font-size:14px;padding:0px;margin:0px;'>"+names[x].firstChild.nodeValue+"</td></tr>"
						}
						pipeitable.innerHTML=code;
				}
			}
		}
		//4.向服务器发送
		xhr.open("get","GoodsServlet?method=ajaxSearch&key="+key);
		xhr.send();
	}
</script>
<script type="text/javascript" src="js/modernizr.custom.min.js"></script>    
	<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
	<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
	<script src="js/json.js" type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			$('.popup-with-zoom-anim').magnificPopup({
				type: 'inline',
				fixedContentPos: false,
				fixedBgPos: true,
				overflowY: 'auto',
				closeBtnInside: true,
				preloader: false,
				midClick: true,
				removalDelay: 300,
				mainClass: 'my-mfp-zoom-in'
			});
		});
	</script>	
</head>
<body style="background-color: threeddarkshadow;">
<!--header-->
<%--//这里独立创建一个头部jsp，是因为在其他jsp页面也会用的到，为了简化代码量 --%>
<div class="header">
	<div class="header-top">
		<div class="container">
		
		<div class="col-sm-4 world">
			<ul >
			<li>
				<select class="in-drop1">
			    <option>英语</option>
				<option>日语</option>
			    <option>法语</option>
			    </select>
		    </li>
			<li><select class="in-drop1">
				<option>美元</option>
				<option>欧元</option>
				<option>人名币</option>
				</select>
			</li>			
			</ul>
		</div>
		
		<div class="col-sm-4 logo">
			<a href="index.jsp"><img src="images/logo.png" alt=""></a>	
		</div>
			
		<div class="col-sm-4 header-left">
		<%--通过获取到的登陆的返回值来判断是否登陆成功 --%>
			<c:choose>
				<c:when test="${sessionScope.Loginuser ne null }">
				<a href="UserServlet?method=information&userID=${sessionScope.Loginuser.userID}"><img style="width:40px;height: 40px;border-radius:20px;border:2px solid black" src="${sessionScope.Loginuser.image }" /></a>
				<span style="width:10px">${sessionScope.Loginuser.realname }</span>
				<a href="UserServlet?method=loginoff&userID=${sessionScope.Loginuser.userID}" style=" font-size: 12px"> 退出</a>
				</c:when>
				<c:otherwise>
					<p class="log"><a href="account.jsp"  >登陆</a>
					<span>or</span><a  href="register.jsp"  >注册</a></p>
				</c:otherwise>
			</c:choose>
			<div class="cart box_1">
				<a href="checkout.jsp">
				<h3> 
					<div class="total">
						<span >${sessionScope.total }</span>
					</div>
					<img src="images/cart.png" alt=""/>
				</h3>
				</a>
					<p><a href="javascript:;" class="simpleCart_empty">购物车</a></p>
					</div>
					<div class="clearfix"> </div>
		</div>
		
		<div class="clearfix"> </div>
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-sm-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>18827512215</span>
				</div>
		 <div class="col-sm-8 h_menu4">
				<ul class="memenu skyblue">
					  <li class=" grid"><a  href="index.jsp">首页</a></li>	
				      <li><a  href="GoodsServlet?method=listgoodsbyname&name=男装">男装</a>
				      	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>服装</h4>
									<ul>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=短袖">短袖</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=长袖">长袖</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=外套">外套</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=牛仔裤">牛仔裤</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=风衣">风衣</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>鞋子</h4>
									<ul>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=休闲鞋">休闲鞋</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=运动鞋">运动鞋</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=波鞋">波鞋</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=韩版高帮鞋">韩版高帮鞋</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=拖鞋">拖鞋</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>潮流品牌</h4>
									<ul>
										<li><a href="GoodsServlet?method=listgoodbybrand&brand=新百伦">新百伦</a></li>
										<li><a href="GoodsServlet?method=listgoodbybrand&brand=耐克">耐克</a></li>
										<li><a href="GoodsServlet?method=listgoodbybrand&brand=361°">361°</a></li>
										<li><a href="GoodsServlet?method=listgoodbybrand&brand=阿迪达斯">阿迪达斯</a></li>
										<li><a href="GoodsServlet?method=listgoodbybrand&brand=特步">特步</a></li>
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
					</li>
				    <li class="grid"><a  href="GoodsServlet?method=listgoodsbyname&name=女装">	女装</a>
					  	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>服装</h4>
									<ul>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=连衣裙">连衣裙</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=超短裙">超短裙</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=毛裤">毛裤</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=长裙">长裙</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=帽子">帽子</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>鞋子</h4>
									<ul>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=板鞋">板鞋</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=凉鞋">凉鞋</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=长靴">长靴</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=高跟鞋">高跟鞋</a></li>
										<li><a href="GoodsServlet?method=listgoodsbyseris&seris=棉鞋">棉鞋</a></li>
									</ul>
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>潮流品牌</h4>
									<ul>
										<li><a href="GoodsServlet?method=listgoodbybrand&brand=新百伦">新百伦</a></li>
										<li><a href="GoodsServlet?method=listgoodbybrand&brand=耐克">耐克</a></li>
										<li><a href="GoodsServlet?method=listgoodbybrand&brand=361°">361°</a></li>
										<li><a href="GoodsServlet?method=listgoodbybrand&brand=阿迪达斯">阿迪达斯</a></li>
										<li><a href="GoodsServlet?method=listgoodbybrand&brand=特步">特步</a></li>
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
			    </li>
				<li><a  href="OrderServlet?method=listallorder&userid=${sessionScope.Loginuser.userID }">我的订单</a></li>				
				<li><a class="color6" href="checkout.jsp">我的购物车</a></li>
			  </ul> 
			</div>
			<div class="col-sm-2 search">
			<table cellspacing="0" cellpadding="0" style="margin: 0px;padding: 0px;"  >
				<tr style="margin: 0px;padding: 0px;">
					<td style="margin: 0px;padding: 0px;">
						<input oninput="ajaxSearch()" id="key" value="${key}" type="text"
							onmouseover="this.style.border='1px solid black'"
							onmouseout="this.style.border='1px solid #36D2B6'"
							style="width: 140px; height: 24px; border: 1px solid #36D2B6; position: relative; top: -3px;" />
						<a href="javascript:searchGoods('GoodsServlet?method=searchGoods&key=')" style="cursor: pointer" >
						<i class="glyphicon glyphicon-search"> </i> </a>
					</td>
				</tr>
				<tr style="margin: 0px;padding: 0px;">
					<td style="margin: 0px;padding: 0px;"  align="center">
						<table frame="box" id="pipei"  style="margin-left: -16px; margin-top:-5px;padding: 0px;width: 140px;position: absolute;z-index: 2;background-color: white;left: 31px;filter:alpha(opacity=0.2)">
						</table>
					</td>
				</tr>
				</table>		
			</div>
		<div class="clearfix"> </div>
	</div>
</div>
</div>
</body>
</html>