<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DouPHP 管理中心 - 商品分类 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
</head>
<body>
<div id="dcWrap">
 <div id="dcHead">
 <div id="head">
  <div class="logo"><a href="index.html"><img src="images/dclogo.gif" alt="logo"></a></div>
  <div class="nav">
   <ul>
    <li class="M"><a href="JavaScript:void(0);" class="topAdd">新建</a>
     <div class="drop mTopad"><a href="product.php?rec=add">商品</a> <a href="article.php?rec=add">文章</a> <a href="nav.php?rec=add">自定义导航</a> <a href="show.html">首页幻灯</a> <a href="page.php?rec=add">单页面</a> <a href="manager.php?rec=add">管理员</a> <a href="link.html"></a> </div>
    </li>
    <li><a href="../index.php" target="_blank">查看站点</a></li>
    <li><a href="index.php?rec=clear_cache">清除缓存</a></li>
    <li><a href="http://help.douco.com" target="_blank">帮助</a></li>
    <li class="noRight"><a href="module.html">DouPHP+</a></li>
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
  </div>
 </div>
</div>
<!-- dcHead 结束 --> <div id="dcLeft"><div id="menu">
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
</div></div>
 <div id="dcMain">
   <!-- 当前位置 -->
<div id="urHere">DouPHP 管理中心<b>></b><strong>商品分类</strong> </div>   <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="add_product_category.html" class="actionBtn add">添加分类</a>商品分类</h3>
    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
      <tr>
        <th width="120" align="left">分类名称</th>
        <th align="left">别名</th>
        <th align="left">简单描述</th>
       <th width="60" align="center">排序</th>
        <th width="80" align="center">操作</th>
     </tr>
            <tr>
        <td align="left"> <a href="product.php?cat_id=1">电子数码</a></td>
        <td>digital</td>
        <td>电子产品销售</td>
        <td align="center">10</td>
        <td align="center"><a href="product_category.php?rec=edit&cat_id=1">编辑</a> | <a href="product_category.php?rec=del&cat_id=1">删除</a></td>
     </tr>
            <tr>
        <td align="left">- <a href="product.php?cat_id=4">智能手机</a></td>
        <td>phone</td>
        <td>智能手机销售</td>
        <td align="center">50</td>
        <td align="center"><a href="product_category.php?rec=edit&cat_id=4">编辑</a> | <a href="product_category.php?rec=del&cat_id=4">删除</a></td>
     </tr>
            <tr>
        <td align="left">- <a href="product.php?cat_id=5">平板电脑</a></td>
        <td>tabletpc</td>
        <td>平板电脑销售</td>
        <td align="center">50</td>
        <td align="center"><a href="product_category.php?rec=edit&cat_id=5">编辑</a> | <a href="product_category.php?rec=del&cat_id=5">删除</a></td>
     </tr>
            <tr>
        <td align="left"> <a href="product.php?cat_id=2">家居百货</a></td>
        <td>home</td>
        <td>家居百货产品销售</td>
        <td align="center">20</td>
        <td align="center"><a href="product_category.php?rec=edit&cat_id=2">编辑</a> | <a href="product_category.php?rec=del&cat_id=2">删除</a></td>
     </tr>
            <tr>
        <td align="left"> <a href="product.php?cat_id=3">母婴用品</a></td>
        <td>baby</td>
        <td>母婴用品销售</td>
        <td align="center">30</td>
        <td align="center"><a href="product_category.php?rec=edit&cat_id=3">编辑</a> | <a href="product_category.php?rec=del&cat_id=3">删除</a></td>
     </tr>
          </table>
           </div>
 </div>
 <div class="clear"></div>
<div id="dcFooter">
 <div id="footer">
  <div class="line"></div>
  <ul>
   版权所有 © 2013-2015 漳州豆壳网络科技有限公司，并保留所有权利。
  </ul>
 </div>
</div><!-- dcFooter 结束 -->
<div class="clear"></div> </div>
</body>
</html>