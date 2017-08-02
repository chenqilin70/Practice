<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>DouPHP 管理中心 - 商品分类 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="Copyright" content="Douco Design." />

<link rel="stylesheet" href="http://view.jqueryfuns.com/预览-/2014/9/16/98cd924512db6719204bea8b39a78b09/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">

<link href="css/public.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="layer/jquery-3.2.0.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
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
<!--批量删除商品的js -->
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
		 var index = obj.selectedIndex;
		 var value = obj.options[index].value; 
		 window.location.href='selectProductAction1!selectbyprice?selectid='+value;
	}
</script>
<!-- 根据不同的品牌和类来查询商品 -->
<script type="text/javascript">
	function choosebrand()
	{
		 var obj=document.getElementById("brand");
		 var index = obj.selectedIndex;
		 var value=obj.options[index].value; 
		 window.location.href='selectProductAction1!selectbybrand?chosebrand='+value;
	}
	function chooseseris()
	{
		 var obj=document.getElementById("seris");
		 var index = obj.selectedIndex;
		 var value=obj.options[index].value; 
		 window.location.href='selectProductAction1!selectbyseris?choseseris='+value;
	}
</script>
</head>
<body>
<s:i18n name="product_en_US"></s:i18n>
<!-- struts2的数据标签，直接在加载页面的 时候请求action -->
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

	<div id="urHere">FiveGroup<b>></b>
		<strong><s:text name="ProductTitle" ></s:text><div style="margin-left: 500px;"></div></strong>
		<s:url id="indexUS" namespace="/" action="locale" >
	    	<s:param name="request" >en</s:param>
	    </s:url>
	   	<s:url id="indexCN" namespace="/" action="locale" >
	        <s:param name="request" >zh</s:param>
	    </s:url>
		<s:a href="%{indexUS}" style="color:gray" >English</s:a>
	    <s:a href="%{indexCN}" style="color:gray">中文</s:a>
	</div> 
	<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
    	<h3>
        	<a href="addproduct.jsp" class="actionBtn add" ><s:text name="addProduct" ></s:text></a><s:text name="ProductTitle"></s:text>
        </h3>
        <div class="table-responsive table2excel" >
    	<table class="table table-striped table-bordered table-hover" width="100%" border="0"  cellpadding="7" >
    			
    			<tr class="noExl" style="padding: 0px;margin: 0px">
    			<td align="center"></td>
    			<td align="center"></td>
    			<td align="center">
	    			<select id="brand" onclick="choosebrand()">
	      		  	<s:iterator value="#attr.brand" id="li"  status="">
	    				<option>
	    					<s:property value="li"></s:property>
	    				</option>
	    			</s:iterator>
	    			</select>
    			</td>
    			<td align="center">
    				<select id="seris" onclick="chooseseris()">
      		  		<s:iterator value="#attr.seriss"  id="li1"  status="">
    					<option>
    						<s:property value="li1"></s:property>
    					</option>
    				</s:iterator>
    				</select>
    			</td>
    			<td colspan="1" align="center"></td>
    			<td colspan="" align="center"></td>
    			<td colspan="" align="center"></td>
    			<td colspan="1" style="padding-top: 5px;padding-bottom:2px;" align="center">
    				<select onchange="choose()" id="price" >
    					<option value="2">￥120-200</option>
    					<option value="1">￥0-120</option>
    					<option value="3">￥200-300</option>
    					<option value="4">￥>300</option>
    				</select>
    			</td>
    			<td align="center"></td>
    			<td align="center" colspan="1"><a id="btn" href="javascript:void()" onclick="outputSelect()" style="font-size: 12px;"><s:text name="output" ></s:text></a>|
    			<a href="javascript:void()" onclick="deleteSelect()" style="font-size: 12px;"><s:text name="delete" ></s:text></a></td>
    			<td align="center">商品详情</td>
    			</tr>
    			<tr>
		        <td width="30" align="center"><s:text name="productid" ></s:text></td>
		        <td width="60" align="center"><s:text name="name" ></s:text></td>
		        <td width="60" align="center"><s:text name="brand" ></s:text></td>
		       	<td width="60" align="center"><s:text name="seris" ></s:text></td>
		        <td width="60" align="center"><s:text name="type" ></s:text></td>
		        <td width="60" align="center"><s:text name="price" ></s:text></td>
		        <td width="60" align="center"><s:text name="typeid" ></s:text>ID</td>
		        <td width="60" align="center"><s:text name="picture" ></s:text></td>
		        <td width="60" align="center"><s:text name="operation" ></s:text></td>
		        <td width="60" align="center"><input type=checkbox  onClick="selectAll(this.checked)" name="productid"><s:text name="allselect" ></s:text>/
		        <input type=checkbox onclick="reveseSelect()" name="product"><s:text name="noselect" ></s:text></td>
		        <td width="60" align="center"><a href="#" class="parentIframe"  >查看</a></td>
		        <!-- 注意href="#"与href=""是有区别的 -->
     			</tr>
    			<s:iterator value="#attr.ps" status="stuts">
    			<s:if test="#stuts.odd == true">
		    	<tr style="background-color:white">
			        <td align="center"><s:property value="productid" /></td>
			        <td align="center"><s:property value="name" /></td>
			        <td align="center"><s:property value="brand" /></td>
			        <td align="center"><s:property value="seris" /></td>
			        <td align="center"><s:property value="type" /></td>
			        <td align="center">￥:<s:property value="basicprice" /></td>
			        <td align="center"><s:property value="typeid" /></td>
			        <td align="center"><img src="<s:property value="image" />"></td>
			        <td align="center"><a href="updateproduct.jsp?productid=${productid}" style="color:green"><s:text name="editor" ></s:text></a></td>
		    		<td align="center"><a href="#" class="deleteProduct" productid='${productid}' style="color:red" ><s:text name="delete" ></s:text></a><input type=checkbox name=productid value="<s:property value="productid" />"></td>
		    		<td align="center"><a href="#" class="parentIframe"  productid='${productid}'>查看</a></td>
		    	</tr>
		     	</s:if>
             	<s:else>
             	<tr style="background-color:#EEEEEE;">
			        <td align="center"><s:property value="productid" /></td>
			        <td align="center"><s:property value="name" /></td>
			        <td align="center"><s:property value="brand" /></td>
			        <td align="center"><s:property value="seris" /></td>
			        <td align="center"><s:property value="type" /></td>
			        <td align="center">￥:<s:property value="basicprice" /></td>
			        <td align="center"><s:property value="typeid" /></td>
			        <td align="center"><img src="<s:property value="image" />"></td>
			        <td align="center"><a href="updateproduct.jsp?productid=${productid}" style="color:green"><s:text name="editor" ></s:text></a></td>
		    		<td align="center"><a href="#" class="deleteProduct" productid='${productid}' style="color:red"><s:text name="delete" ></s:text></a><input type=checkbox name=productid value="<s:property value="productid" />"></td>
		    		<td align="center"><a href="#" class="parentIframe" productid='${productid}'>查看</a></td>
		    	</tr>
             	</s:else>
				</s:iterator >
			<s:iterator value="#attr.pg">
				<a href="selectProductAction!selectproduct?pg.page=<s:property value='firstpage'/>&pg.value=10" ><s:text name="firstpage" ></s:text></a>
				<s:text name="nowpage" ></s:text><font style="color:red"><s:property value='nowpage'/></font><s:text name="page" ></s:text>
				<a href="selectProductAction!selectproduct?pg.page=<s:property value='prexpage' />&pg.value=10" ><s:text name="prexpage" ></s:text></a>
				<a href="selectProductAction!selectproduct?pg.page=<s:property value='nextpage' />&pg.value=10" ><s:text name="nextpage" ></s:text></a>
				<s:text name="allpage" ></s:text><font style="color:red"><s:property value='lastpage'/></font><s:text name="page" ></s:text>
				<a href="selectProductAction!selectproduct?pg.page=<s:property value='lastpage' />&pg.value=10" ><s:text name="lastpage" ></s:text></a>
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
			name: "Excel Document Name",
			filename: "myFileName",
			exclude_img: true,
			exclude_links: true,
			exclude_inputs: true
		});
	});
});
</script>
<!-- 弹出一个新的小窗口js -->
<script>
//弹出一个iframe层  添加通告
$('.parentIframe').on('click', function(){
alert($(this).attr("productid"))
  layer.open({
  type: 2,
  title: '商品详细信息 ',
  maxmin: true,
  shadeClose: true, //点击遮罩关闭层
  area : ['600px' , '450px'],
  content:'checkProductAction!checkproduct?productid='+$(this).attr("productid"),
  });
});
</script>
</body>
</html>