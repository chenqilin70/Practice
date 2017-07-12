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
<%@include file="Head.jsp" %>
<div id="dcMain">
<div id="urHere">DouPHP 管理中心<b>></b><strong>商品分类</strong> </div>   
	<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="add_product_category.html" class="actionBtn add">添加分类</a>商品分类</h3>
    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
    <tr>
    	<td colspan="5">添加商品 </td>
    </tr>
      <tr>
        <th width="120" align="left">分类名称</th>
        <th align="left">别名</th>
        <th align="left">简单描述</th>
       <th width="60" align="center">排序</th>
        <th width="80" align="center">操作</th>
     </tr>
            <tr>
        <td align="left"> <a href="product.php?cat_id=3">母婴用品</a></td>
        <td>baby</td>
        <td>母婴用品销售</td>
        <td align="center">30</td>
        <td align="center"><a href="product_category.php?rec=edit&cat_id=3">编辑</a> | <a href="product_category.php?rec=del&cat_id=3">删除</a></td>
     </tr>
          </table>
      <form action="ProductAction!addProduct" method="post">
      	商品名字:<input type="text" name="p.name"><br>
      	商品品牌:<input type="text" name="p.brand"><br>
      	商品类型:<input type="text" name="p.seris"><br>
      	商品描述:<input type="text" name="p.description"><br>
      	商品价格:<input type="text" name="p.basicprice"><br>
      	商品类型id:<input type="text" name="p.typeid"><br>
      	商品图片:<input type="text" name="p.image"><br>
      	<button type="submit"> 提交
      </form>
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