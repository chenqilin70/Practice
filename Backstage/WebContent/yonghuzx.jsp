<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>杰仔专卖网-用户中心	 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
</head>
<body>
<div id="dcWrap">
	<div id="dcHead">
 		<div id="head">
  			<div class="logo"><a href="index.jsp"><img src="images/dclogo.gif" alt="logo"></a></div>
  			<div class="nav">
  			<ul>
    			<li class="M"><a href="JavaScript:void(0);" class="topAdd">新建</a>
	     			<div class="drop mTopad">
	     			<a href="product.php?rec=add">商品</a> 
	     			<a href="article.php?rec=add">文章</a> 
	     			<a href="nav.php?rec=add">自定义导航</a> 
	     			<a href="show.jsp">首页幻灯</a> 
	     			<a href="page.php?rec=add">单页面</a> 
	     			<a href="manager.php?rec=add">管理员</a> 
	     			<a href="link.jsp"></a> </div>
   				</li>
			    <li><a href="../index.php" target="_blank">查看站点</a></li>
			    <li><a href="index.php?rec=clear_cache">清除缓存</a></li>
			    <li><a href="http://help.douco.com" target="_blank">帮助</a></li>
			    <li class="noRight"><a href="module.jsp">DouPHP+</a></li>
   			</ul>
   			<ul class="navRight">
    			<li class="M noLeft"><a href="JavaScript:void(0);">您好，admin</a>
    			<div class="drop mUser">
			    <a href="manager.php?rec=edit&id=1">编辑我的个人资料</a>
			    <a href="manager.php?rec=cloud_account">设置云账户</a>
     			</div>
    			</li>
    			<li class="noRight"><a href="login.php?rec=logout">退出</a></li>
   			</ul>
  			</div><!-- nav结尾 -->
 		</div><!-- head结尾 -->
	</div><!-- dcHead 结束 -->
 
	<div id="dcLeft">
		<div id="menu">
 		<ul class="top">
  			<li><a href="index.jsp"><i class="home"></i><em>管理首页</em></a></li>
 		</ul>
 		<ul>
	  		<li><a href="system.jsp"><i class="system"></i><em>系统设置</em></a></li>
	  		<li><a href="yonghuzx.jsp"><i class="nav"></i><em>用户中心</em></a></li>
	  		<li><a href="yonghugl.jsp"><i class="show"></i><em>用户管理</em></a></li>
	 	</ul>
   		<ul>
  			<li><a href="dingdangl.jsp"><i class="productCat"></i><em>订单管理</em></a></li>
  			<li><a href="shangpgl.jsp"><i class="product"></i><em>商品管理</em></a></li>
 		</ul>
  		<ul>
  			<li><a href="tongjigl.jsp"><i class="articleCat"></i><em>统计管理</em></a></li>
  			<li><a href="gonggaogl.jsp"><i class="article"></i><em>公告管理</em></a></li>
 		</ul>
   		<ul class="bot">
  			<li><a href="shujubf.jsp"><i class="backup"></i><em>数据备份</em></a></li>
  			<li><a href="manager.jsp"><i class="manager"></i><em>网站管理员</em></a></li>
 		</ul>
		</div>
	</div><!-- dcLeft 结束 -->
 
	<div id="dcMain">
		<div id="urHere"><b>杰仔专卖网-管理中心</b></div>   
			<div id="manager" class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
    		<h3><a href="addmanager.jsp?rec=add" class="actionBtn">用户登录</a>个人中心</h3>
    		<table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
    		<tr align="center" style="font-size: 20px;">
    			<td colspan="7">个人中心</td>
    		</tr>
     		<tr>
		    	<th width="30" align="center">编号</th>
		      	<th align="center">用户名</th>
		      	<th align="center">真实姓名</th>
		      	<th align="center">E-mail地址</th>
		      	<th align="center">性别</th>
		      	<th align="center">年龄</th>
		      	<th align="center">操作</th>
     		</tr>
          	<tr>
      			<td align="center">1</td>
      			<td align="center">dabaojian</td>
      			<td align="center">大保健</td>
      			<td align="center">495873513@qq.com</td>
      			<td align="center">男</td>
      			<td align="center">21</td>
      			<td align="center"><a href="addmanager.jsp?rec=edit&id=1">编辑</a> | <a href="manager.jsp?rec=del&id=1">删除</a></td>
     		</tr>
         	</table>
            </div>
 	</div><!-- dcMain 结束 -->
 	<div class="clear"></div>
 	
	<div id="dcFooter">
 		<div id="footer" align="center">
  			<div class="line"></div>
 				 <p style="margin-top: 10px;">版权所有 © 2013-2015 漳州豆壳网络科技有限公司，并保留所有权利。</p>
 		</div>
	</div><!-- dcFooter 结束 -->
	<div class="clear"></div> </div>
</body>
</html>