<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s"   uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电商后台 -管理中心</title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
</head>
<body>
 <div id="dcHead">
	<div id="head">
  	<div class="logo"><a href="index.jsp"><img src="images/dclogo.gif" alt="logo"></a></div>
  	<div class="nav">
   	<ul>
    	<li class="M"><a href="JavaScript:void(0);" class="topAdd">新建</a>
     		<div class="drop mTopad"><a href="product.php?rec=add">商品</a> <a href="article.php?rec=add">文章</a> <a href="nav.php?rec=add">自定义导航</a> <a href="show.jsp">首页幻灯</a> <a href="page.php?rec=add">单页面</a> <a href="manager.php?rec=add">管理员</a> <a href="link.jsp"></a> </div>
    	</li>
    	<li><a href="../index.php" target="_blank">查看站点</a></li>
    	<li><a href="index.php?rec=clear_cache">清除缓存</a></li>
    	<li><a href="http://www.mycodes.net" target="_blank">帮助</a></li>
   	</ul>
    <ul class="navRight">
    	<li class="M noLeft"><a href="JavaScript:void(0);">您好，${sessionScope.user.realname }</a>
     		<div class="drop mUser">
      		<a href="manager.jsp">编辑我的个人资料</a>
     		</div>
    	</li>
    	<li class="noRight"><a href="login.jsp">退出</a></li>
   </ul>
   </div>
   </div>
</div>
<!-- dcHead 结束 --> 

<div id="dcLeft"><div id="menu">
	<ul class="top">
  		<li><a href="index.jsp"><i class="home"></i><em>管理首页</em></a></li>
 	</ul>
 	<ul>
  		<li><a href="usercenter.jsp"><i class="nav"></i><em>用户中心</em></a></li>
  		<li><a href="usercontrol.jsp"><i class="show"></i><em>用户管理</em></a></li>
	</ul>
    <ul>
		<li><a href="ordercontrol.jsp"><i class="productCat"></i><em>订单管理</em></a></li>
	  	<li><a href="goodcontrol.jsp"><i class="product"></i><em><s:text name="productcontrol" ></s:text></em></a>
	  		<ul>
	  			<li><a href="usercenter.jsp"><i class="nav"></i><em>用户中心</em></a></li>
  				<li><a href="usercontrol.jsp"><i class="show"></i><em>用户管理</em></a></li>
	  		</ul>
	  	</li>
 	</ul>
  	<ul>
  		<li><a href="statistical!index.action"><i class="articleCat"></i><em>统计管理</em></a></li>
  		<li><a href="noticecontrol.jsp"><i class="article"></i><em>公告管理</em></a></li>
 	</ul>
 	<ul class="bot">
  		<li><a href="manager.jsp"><i class="manager"></i><em>网站管理员</em></a></li>
 	</ul>
</div>
<br/><br/>
<div  style="position:fixed;  height:250px;width:170px ; border:1px solid gray; background-image: url('images/notice.jpg'); margin-left: 4px;">
<br/><br/><br/><br/><div align="center"  style="font-family: '方正舒体';font-size: 25px; color: blue" >公告</div>

<s:action name="NoticeAction1!selectRoughNotice"  namespace="/"></s:action>
<marquee scrollamount="2" width="170px" height="120px" direction="up">
<s:iterator value="#attr.n1">
	<s:a href="noticecontrol.jsp"><s:property value="notice"/></s:a>
	<div align="right"><s:property value="date"/></div>
	</s:iterator>
</marquee>
</div>

</div>


<!-- 左侧导航栏结束 -->
</body>
</html>