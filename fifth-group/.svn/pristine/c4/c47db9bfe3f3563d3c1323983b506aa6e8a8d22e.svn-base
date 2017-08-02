<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>DouPHP 管理中心 - 商品分类 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="http://view.jqueryfuns.com/预览-/2014/9/16/98cd924512db6719204bea8b39a78b09/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<!--删除单一商品的jquery事件-->
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
<!-- 删除商品的js -->
<script type="text/javascript">
function selectAll(x)
{
	var select=document.getElementsByName("productid");
	for(var y in select)
	{
		select[y].checked=x;
	}
}
function  reveseSelect()
{
	var select=document.getElementsByName("productid");
	for(var  y in select)
	{
		(select[y].checked==true)?(select[y].checked=false):(select[y].checked=true);
	}
}
function deleteSelect()
{
	var ids="";
	var select=document.getElementsByName("productid");
	for(var  x in select)
	{
		if(select[x].checked==true&&select[x].type=='checkbox')
		{
			ids=ids+select[x].value+",";
			alert(ids)
		}		
	}
	if(window.confirm("确认要删除选中的商品吗？"))
	{
		window.location.href='deleteProductAction!deleteproduct?productid='+ids;
	}
}
</script>
<!-- 按照不同的价格分段来查询商品 -->
<script type="text/javascript">
	function choose()
	{
		 var obj=document.getElementById("price");
		 alert(obj);
		 var index = obj.selectedIndex;
		 var value = obj.options[index].value; 
		 alert(value);
		 window.location.href='selectProductAction1!selectbyprice?selectid='+value;
	}
</script>
</head>
<body>
<div id="dcWrap">
<%@include file="Head.jsp" %>
<div id="dcMain">
<div id="urHere">FiveGroup<b>></b></div>   
	<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <div class="table-responsive table2excel" >
    	<table class="table table-striped table-bordered table-hover" width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
    		<tr>
    		<th ></th>
    		<th ></th>
    		<th >
    			<select id="brand" onclick="choosebrand()">
      		  	<s:iterator value="#attr.brand" id="li"  status="">
    				<option>
    					<s:property value="li"></s:property>
    				</option>
    			</s:iterator>
    			</select>
    		</th>
    		<th ><select>
      		  	<s:iterator value="#attr.seriss"  id="li1"  status="">
    				<option>
    					<s:property value="li1"></s:property>
    				</option>
    			</s:iterator>
    			</select>
    		</th>
    		<th colspan="1" style="padding-top: 2px;padding-bottom: 2px;">
    			<select onchange="choose()" id="price" >
    				<option value="1" >￥0-120</option>
    				<option value="2">￥120-200</option>
    				<option value="3">￥200-300</option>
    				<option value="4">￥>300</option>
    			</select>
    		</th>
    		<th colspan="1"></th>
    		<th colspan="1"></th>
    		<th colspan="1"></th>
    		<th colspan="1"></th>
    		<th colspan="1"><a id="btn" href="javascript:void()" onclick="outputSelect()" style="font-size: 12px;">导出</a>|<a href="javascript:void()" onclick="deleteSelect()" style="font-size: 12px;">删除</a></th>
    		<th colspan="1"></th>
    		</tr>
    		<tr>
		        <td width="30" align="center">编号</td>
		        <td width="50" align="center">名称</td>
		        <td width="60" align="center">品牌</td>
		       	<td width="60" align="center">系列</td>
		        <td width="60" align="center">类型</td>
		        <td width="50" align="center">描述</td>
		        <td width="80" align="center">价格</td>
		        <td width="40" align="center">类型ID</td>
		        <td width="80" align="center">图片</td>
		        <td width="80" align="center">操作</td>
		        <td width="80" align="center"><input type=checkbox  onClick="selectAll(this.checked)" name="productid">全选/<input type=checkbox onclick="reveseSelect()" name="product">反选</td>
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
		    	<td align="center"><a href="" class="deleteProduct" productid='${productid}' style="color:red" >删除</a><input type=checkbox name=productid value="<s:property value="productid" />"></td>
		     </tr>
		     </s:if>
             <s:else>
             <tr style="background-color:#EEEEEE;">
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
		    	<td align="center"><a href="" class="deleteProduct" productid='${productid}' style="color:red">删除</a><input type=checkbox name=productid value="<s:property value="productid" />"></td>
		     </tr>
             </s:else>
			 </s:iterator >
			 <s:iterator value="#attr.pg">
			 <tr style="background-color:#EEEEEE;">
				<td colspan="1" align="center"><a href="selectProductAction!selectproduct?pg.page=<s:property value='firstpage'/>&pg.value=10" >首     页</a></td>
				<td colspan="3" align="center">当前第<font style="color:red"><s:property value='nowpage'/></font>页</td>
				<td colspan="2" align="center"><a href="selectProductAction!selectproduct?pg.page=<s:property value='prexpage' />&pg.value=10" >上一页</a></td>
				<td colspan="2" align="center"><a href="selectProductAction!selectproduct?pg.page=<s:property value='nextpage' />&pg.value=10" >下一页</a></td>
				<td colspan="2" align="center">共计<font style="color:red"><s:property value='lastpage'/></font>页</td>
				<td colspan="1" align="center"><a href="selectProductAction!selectproduct?pg.page=<s:property value='lastpage' />&pg.value=10" >尾     页</a></td>
			 </tr>
			 </s:iterator>
   			</table>
   		</div>
      </div>
</div>
</div>
<div id="dcFooter"></div>
 <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="dist/jquery.table2excel.js"></script>
<script>
$(function() {
	$("#btn").click(function(){
		$(".table2excel").table2excel({
			exclude: ".noExl",
			name: "Excel Document Name",
			filename: "myFileName",
			exclude_img: true,
			exclude_links: true,
			exclude_inputs: true
		});
	});
});
</script>
</body>
</html>