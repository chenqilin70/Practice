<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="background-color: #EEEEEE">
<table width="100%" border="0" cellpadding="8" cellspacing="0" style="margin-left: -300px;">
    	<s:iterator value="#attr.update">
    		<tr>
      			<td width="80" align="right">商品编号:<s:property value="productid" /></td>
      		</tr>
      		<tr>
      			<td width="80" align="right">商品名称:<s:property value="name" /></td>
      		</tr>
      		<tr>
       			<td align="right">商品品牌:<s:property value="brand" /></td>
      		</tr>
      		<tr>
      			<td align="right">商品类型:<s:property value="type" /></td>
      		</tr>
      		<tr>
       			<td align="right">商品系列:<s:property value="seris" /></td>
      		</tr>
      		<tr>
      		 	<td align="right">商品价格:<s:property value="basicprice" /></td>
      		</tr>
      		<tr>
       			<td align="right">商品描述:<s:property value="description" /></td>
      		</tr>
      		<tr>
       			<td align="right">商品类型id:<s:property value="typeid" /></td>
      		</tr>
      		<tr>
       			<td align="right">商品图片:<img src="<s:property value="image" />"></td>
      		</tr>
      		</s:iterator>
      	</table>
</body>
</html>