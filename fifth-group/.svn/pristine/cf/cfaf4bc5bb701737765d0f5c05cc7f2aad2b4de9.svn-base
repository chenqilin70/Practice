<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DouPHP 管理中心 - 商品分类 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript">
$(function(){
	$(".deleteProduct").click(function(){
		var  result=confirm('确认后该操作无法撤销，是否删除？');
		if(result)
		{
			window.location.href='deleteProductAction!deleteproduct?productid='+$(this).attr("productid");
		}
		return false;
	})
})
</script>
</head>
<body>
<!-- 这是用Action标签来进行参数的传递方法 -->
<s:action name="selectProductAction!selectproduct" namespace="/">
	<s:param name="pg.page">
		<s:if test="pg==null">1</s:if>
	<s:else>
		<s:property value="#request.pg.page" />
	</s:else>
	</s:param>
	<s:param name="pg.value">10</s:param>
</s:action>
<div id="dcWrap">
<%@include file="Head.jsp" %>
<div id="dcMain">
<div id="urHere">FiveGroup<b>></b><strong>商品信息列表</strong> </div>   
	<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3>
        	<a href="addproduct.jsp" class="actionBtn add" >添加商品</a>商品信息列表
        </h3>
        <a href="outputexcelAction!outputdata">导出数据</a>
    	<table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
    		<tr>
    			<th colspan="10"></th>
    			<th colspan="1">导出|删除</th>
    		</tr>
    		<tr>
		        <th width="30" align="center">编号</th>
		        <th width="80" align="center">名称</th>
		        <th width="60" align="center">品牌</th>
		       	<th width="60" align="center">系列</th>
		        <th width="60" align="center">类型</th>
		        <th width="80" align="center">描述</th>
		        <th width="80" align="center">价格</th>
		        <th width="40" align="center">类型ID</th>
		        <th width="80" align="center">图片</th>
		        <th width="80" align="center">操作</th>
		        <th width="80" align="center"><input type=checkbox name=list onClick="this.value=check(this.form.list)">全选/<input type=checkbox name=list>反选</th>
     		</tr>
    		<s:iterator value="#attr.ps" status="stuts">
    			<s:if test="#stuts.odd == true">
		    	<tr style="background-color:white">
			        <td align="center"><s:property value="productid" /></td>
			        <td align="center"><s:property value="name" /></td>
			        <td align="center"><s:property value="brand" /></td>
			        <td align="center"><s:property value="seris" /></td>
			        <td align="center"><s:property value="type" /></td>
			        <td align="center"><s:property value="description" /></td>
			        <td align="center"><s:property value="basicprice" /></td>
			        <td align="center"><s:property value="typeid" /></td>
			        <td align="center"><img src="<s:property value="image" />"></td>
			        <td align="center"><a href="updateproduct.jsp?productid=${productid}" style="color:green">编辑</a></td>
		    		<td align="center"><a href="" class="deleteProduct" productid='${productid}' style="color:red">删除</a><input type=checkbox name=list></td>
		    	</tr>
		     </s:if>
             <s:else>
             	<tr style="background-color:graytext;">
			        <td align="center"><s:property value="productid" /></td>
			        <td align="center"><s:property value="name" /></td>
			        <td align="center"><s:property value="brand" /></td>
			        <td align="center"><s:property value="seris" /></td>
			        <td align="center"><s:property value="type" /></td>
			        <td align="center"><s:property value="description" /></td>
			        <td align="center"><s:property value="basicprice" /></td>
			        <td align="center"><s:property value="typeid" /></td>
			        <td align="center"><img src="<s:property value="image" />"></td>
			        <td align="center"><a href="updateproduct.jsp?productid=${productid}" style="color:green">编辑</a></td>
		    		<td align="center"><a href="" class="deleteProduct" productid='${productid}' style="color:red">删除</a><input type=checkbox name=list></td>
		    	</tr>
             </s:else>
		</s:iterator >
		<s:iterator value="#attr.pg">
			<tr>
				<td colspan="3" align="center"><a href="selectProductAction!selectproduct?pg.page=<s:property value='firstpage'/>&pg.value=10" >首     页</a></td>
				<td colspan="3" align="center"><a href="selectProductAction!selectproduct?pg.page=<s:property value='prexpage' />&pg.value=10" >上一页</a></td>
				<td colspan="3" align="center"><a href="selectProductAction!selectproduct?pg.page=<s:property value='nextpage' />&pg.value=10" >下一页</a></td>
				<td colspan="2" align="center"><a href="selectProductAction!selectproduct?pg.page=<s:property value='lastpage' />&pg.value=10" >尾     页</a></td>
			</tr>
		</s:iterator>
   		</table>
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