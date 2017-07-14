<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DouPHP 管理中心 - 文章分类 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<link href="css/statisticalcontrol.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/echarts.js"></script>
<script type="text/javascript" src="js/china.js"></script>
<script type="text/javascript" src="js/sta_dao.js"></script>
<script type="text/javascript" src="js/sta_option_factory.js"></script>
<script type="text/javascript" src="js/statisticalcontrol.js"></script>
</head>
<body>
<div id="dcWrap">
<%@include file="Head.jsp" %>
<div id="dcMain">
	<div id="urHere">FiveGroup 管理中心<b>></b><strong>统计管理</strong> </div>   
	<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <div id="date_distribution"></div><br/>
        <div id="addr_distribution"></div>
	</div>
</div>
<div class="clear"></div>
<div id="dcFooter">
	<div id="footer">
  	<div class="line"></div>
 	</div>
</div><!-- dcFooter 结束 -->
<div class="clear"></div> </div>
</body>
</html>