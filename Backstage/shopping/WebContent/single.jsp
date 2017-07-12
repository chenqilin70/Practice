<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.shopping.model.bean.Goods"%>
<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>杰仔专卖网-单品</title>
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!---->
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
<script src="js/jquery.min.js"></script>
<script src="js/imagezoom.js"></script>
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
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
			} 
			else{
			 	$(this).removeClass('active');
			 	$(this).next().stop(true,true).slideUp('normal');
				}
		});
	});
</script>
<script defer src="js/jquery.flexslider.js"></script>
<script>
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
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
<script>
	function addgood(){
		document.getElementById("addgood").value
	}
</script>
<script>
	function addGoodstoshopcar(url)
	{
		var  count=document.getElementById("count").value;
		window.location.href=url+"&count="+count;
	}
    function add(){
        var count=document.getElementById("count");
        var a=count.value;
        a++;
        count.value=a;
    }
    function sub(){
        var count=document.getElementById("count");
        var a=count.value;
        if(a>1){
            a--;
            count.value=a;
        }else{
            count.value=1;
        }
    }
    function color(){
    	var color=document.getElementById("color").value;
    }
    function size(){
    	var size=document.getElementById("size").value;
    }
</script>
<script>
$(document).ready(function()
{
	//打开聊天界面的操作
	$("#chatlogo").click(function()
	{      
		if($("#alreadyLogin").val()=='true')
		{
			$("#chat").css("display","block");
			loadMessage();
		}else
		{
			if(window.confirm("登录后才能开启聊天功能！现在去登录吗？"))
			window.location.href="account.jsp";
		}
	})
	//关闭聊天界面的操作
	$("#close").click(function(){
		$("#chat").css("display","none");
	})
	//开始聊天
	$("#send").click(function()
	{
	if($("#editMessages").val().length==0)
		{
			alert('不能发送空内容');
		}else
		{
			//1.将自己即将发送的消息先设置到上面的消息聊天界面中
			var text=$("#chatMessages").val();
			//2.用ajax将消息发给服务器，用post方法
			$.post("UtilServlet",{
				"method":"processChat",
				"words":$("#editMessages").val(),
				"username":$("#username").val()
			},function(data ){
				if(text.length==0)
					$("#chatMessages").val(data);
				else
					$("#chatMessages").val(text+"\r\n"+data);
			});
			$("#editMessages").val("");
		}
	})
})
</script>
</head>
<body>
<%@include file="Head.jsp" %>
<div class="container">
<div class="col-md-9">
	<c:forEach var="G" items="${requestScope.gs }">
	<div class="col-md-5 grid">		
		<div class="flexslider" style="margin-top: 50px">
			<ul class="slides">
				<li data-thumb="${G.image }">
					<div class="img-responsive"> <img style="width: 310px; height:480px; border: 2px solid gray;"  src="${G.image }" data-imagezoom="true" class="img-responsive"> </div>
				</li>
				<li data-thumb="${G.image }">
				    <div class="img-responsive"> <img style="width: 310px; height:480px; border: 2px solid gray;" src="${G.image }" data-imagezoom="true" class="img-responsive"> </div>
				</li>
				<li data-thumb="${G.image }">
				    <div class="img-responsive"> <img style="width: 310px; height:480px; border: 2px solid gray;" src="${G.image }" data-imagezoom="true" class="img-responsive"> </div>
				</li> 
		    </ul>
		</div>
	</div>	
	<div class="col-md-7 single-top-in">
		<div class="single-para simpleCart_shelfItem" style="margin-top: 50px">
			<h1>有关商品的相关信息：</h1>
			<p style="height: 125px">${ G.description}</p>
			<div class="star-on">
				<ul>
					<li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
					<li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
					<li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
					<li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
					<li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
				</ul>
				<div class="review">
					<a href="#"> 3 评论 </a>/
					<a href="#"> 您的评论</a>
				</div>
			</div>
			<label  class="add-to item_price"></label>
		</div>
		<div class="available">
			<h6>请选择类型:</h6>
			<ul>
				<li>尺寸:
				<select id="size" onclick="size()">
				<option>超大号</option>
				<option>大号</option>
				<option>中号</option>
				<option>小号</option>
				<option>超小号</option>
				</select></li>
				<li>商品数量:
				<input type="button" onclick="add()" value="+">
				<input type="text" style="width: 25px; height: 25px" id="count" value="1"/>
				<input type="button" onclick="sub()" value="-">
				<li>颜色：
				<select name="color">
				<option value="土豪金">土豪金</option>
				<option value="炫酷黑">炫酷黑</option>
				<option value="纯白">纯白</option>
				<option value="灰色">灰色</option>
				<option value="天蓝">天蓝</option>
				</select>
				</li>
			</ul>
			<br />
			<p style=" font-size: 14px; color:white;">淘宝价：${G.basicprice }</p><br/>
			<font style=" font-size: 14px; color:white;">快&nbsp;&nbsp;&nbsp;&nbsp;递：湖北省襄阳市襄樊区湖北文理学院新区15栋725</font><br/>
			<br/><p style=" font-size: 14px; color:white;">配&nbsp;&nbsp;&nbsp;&nbsp;送：免运费
			<br/><br/><p style=" font-size: 14px; color:white;"><font>店&nbsp;&nbsp;&nbsp;&nbsp;铺：</font>
			<c:if test="${sessionScope.Loginuser ne null}">
				<input type="hidden"  id="alreadyLogin" value="true"  />
			</c:if>
			<input type="hidden"  id="username" value="${sessionScope.Loginuser.username }"  />
			联系客服<a><img id="chatlogo" src="image/marktp/dianpu.jpg" style="width: 20px; height: 20px; border-radius: 15px; margin-right: 20px"></a>
			收藏店铺<img src="image/marktp/dianpu.jpg" style="width: 20px; height: 20px; border-radius: 15px; "></p>		
		</div>
			<a href="GoodsServlet?method=buyNow&productid=${G.productid}" class="cart item_add" style=" width: 155px;">立即购买</a>
			<a href="javascript:addGoodstoshopcar('GoodsServlet?method=addGoodstoshopcar&productid=${G.productid}')" id="addgood" class="cart item_add" style=" width: 200px; margin-left: 40px">加入购物车</a>
		</div>
		</c:forEach>
	</div>
	<div class="col-md-3 product-bottom">
	</div>
<div ondragstart="rememberPosition()" ondrag="moveChat()" id="chat"
	style="position:absolute;right:50px;top:220px;z-index:20; width: 320px; height: 320px;display: none;">
	<img src="image/User/user.jpeg" style="position: absolute;z-index: -1; width: 320px; height: 290px" usemap="#Map" />
		<map name="Map" id="Map">
		  <area shape="rect" coords="392,55,422,71" id="close" />
		</map>
	<textarea  id="chatMessages"  readonly="readonly" style="opacity:0.7; font-size:12px; width: 282px;height: 180px;margin-left: 20px;margin-top: 20px;overflow: scroll;"></textarea>
	<textarea id="editMessages"  style=" opacity:0.7;font-size:12px;width: 238px;height: 43px;margin-left: 20px;margin-top: 20px;"></textarea><button id="send" >发送</button>
</div>
</div>
</body>
</html>