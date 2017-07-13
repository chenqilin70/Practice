<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
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
function  deleteProduct(){
	var  result=confirm('确认后该操作无法撤销，是否删除？');
	if(result)
	{
		window.location.href='GoodsServlet?method=deleteProduct&productid=';
	}
}
</script>
</head>
<body>
<div id="dcWrap">
<%@include file="Head.jsp" %>
<div id="dcMain">
<div id="urHere">DouPHP 管理中心<b>></b><strong>商品信息列表</strong> </div>   
	<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="addproduct.jsp" class="actionBtn add">添加商品</a>商品信息列表</h3>
    	<table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
    		<tr>
		        <th width="60" align="center">编号</th>
		        <th width="80" align="center">名称</th>
		        <th width="80" align="center">品牌</th>
		       	<th width="80" align="center">系列</th>
		        <th width="80" align="center">类型</th>
		        <th width="80" align="center">描述</th>
		        <th width="80" align="center">价格</th>
		        <th width="80" align="center">类型ID</th>
		        <th width="80" align="center">图片</th>
		        <th width="80" align="center">操作</th>
     		</tr>
		    <tr>
		        <td align="left"><a href="product.php?cat_id=3">母婴用品</a></td>
		        <td align="center">baby</td>
		        <td align="center">baby</td>
		        <td align="center">baby</td>
		        <td align="center">baby</td>
		        <td align="center">baby</td>
		        <td align="center">母婴用品销售</td>
		        <td align="center">30</td>
		        <td align="center">30</td>
		        <td align="center"><a href="updateproduct.jsp" style="color:red">编辑</a> | <a href="javascript:deleteProduct()" style="color:red">删除</a></td>
		    </tr>
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