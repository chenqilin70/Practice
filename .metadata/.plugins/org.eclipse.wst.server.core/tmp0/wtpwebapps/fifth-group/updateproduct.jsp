<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
</head>
<body>
<s:action name="GetProductAction!getproduct" namespace="/"></s:action>
<div id="dcWrap">
<%@include file="Head.jsp" %>
<div id="dcMain">
<div id="urHere">DouPHP 管理中心<b>></b><strong>添加分类</strong> </div>   <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
	<h3>修改商品信息</h3>
	<form action="updateProductAction!updateproduct" method="post" >
    	<table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
    	<s:iterator value="#attr.update">
    		<tr>
      			<td width="80" align="right">商品编号</td>
      			<td><input type="text" value="<s:property value="productid" />" name="p.productid"></td>
      		</tr>
      		<tr>
      			<td width="80" align="right">商品名称</td>
      			<td><input type="text" value="<s:property value="name" />" name="p.name"></td>
      		</tr>
      		<tr>
       			<td align="right">商品品牌</td>
       			<td><input type="text" value="<s:property value="brand" />" name="p.brand"></td>
      		</tr>
      		<tr>
      			<td align="right">商品类型</td>
       			<td><input type="text" value="<s:property value="type" />" name="p.type"></td>
      		</tr>
      		<tr>
       			<td align="right">商品系列</td>
       			<td><input type="text" value="<s:property value="seris" />" name="p.seris"></td>
      		</tr>
      		<tr>
      		 	<td align="right">商品价格</td>
      		 	<td><input type="text" value="<s:property value="basicprice" />" name="p.basicprice"></td>
      		</tr>
      		<tr>
       			<td align="right">商品描述</td>
       			<td><input type="text" value="<s:property value="description" />" name="p.description"></td>
      		</tr>
      		<tr>
       			<td align="right">商品类型id</td>
       			<td><input type="text" value="<s:property value="typeid" />" name="p.typeid"></td>
      		</tr>
      		<tr>
       			<td align="right">商品图片</td>
       			<td><input type="text" value="<s:property value="image" />" name="p.image"></td>
      		</tr>
      		<tr>
       			<td></td>
       			<td>
        			<input type="hidden" name="token" value="b9439ae8" />
        			<input type="hidden" name="cat_id" value="" />
        			<input name="submit" class="btn" type="submit" value="确认修改" />
       			</td>
      		</tr>
      		</s:iterator>
      	</table>
      </form>
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
<div class="clear"></div> </div>
</body>
</html>