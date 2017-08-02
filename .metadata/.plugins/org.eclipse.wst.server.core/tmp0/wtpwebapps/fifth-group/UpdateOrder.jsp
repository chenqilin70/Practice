<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DouPHP 管理中心 - 商品列表 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.autotextarea.js"></script>
<script type="text/javascript">

onload = function()
{
 document.forms['action'].reset();
}

function douAction()
{
 var frm = document.forms['action'];
 frm.elements['new_cat_id'].style.display = frm.elements['action'].value == 'category_move' ? '' : 'none';
}

</script>
</head>
<body>
<div id="dcWrap">
<%@include file="Head.jsp" %>
<div id="dcMain">
<div id="urHere">DouPHP 管理中心</div>   
	<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
<h3>修改订单信息</h3>
<form action="OrderAction!updateorder" method="post">
 <table width="50%" border="0" cellpadding="8" cellspacing="0" class="tableBasic" >
 <s:action name="OrderAction!listOrderbyoid" namespace="/"></s:action>
<tr >
 <td width="30">订单编号</td>
 <td><input type="text" style="width: 500px;font-size: medium;" name="oid" value="<s:property value="order.oid" ></s:property>" readonly="true"></td>
 </tr>
<tr>
 <td width="30">商品名称</td>
 <td ><s:property value="order.good.name"></s:property></td>
 </tr>
<tr>
 <td>商品品牌</td>
 <td><s:property value="order.good.brand"></s:property></td>
 </tr>
<tr>
 <td>购买数量</td>
 <td><input style="font-size: medium;"type="text" name="count"  value='<s:property value="order.prm.count"/>'></td>
 </tr>
<tr>
 <td>商品折扣</td>
 <td><s:property value="order.prm.discount"/></td>
 </tr>
<tr>
 <td>收货人</td>
 <td><input type="text" style="font-size: medium;" name="pe" value="<s:property value="order.ad.user"/>"></td>
 </tr>
<tr>
 <td>联系电话</td>
 <td><input type="text" style="font-size: medium;" name="tel" value="<s:property value="order.ad.tel"/>"></td>
 </tr>
 <tr>
 <td>收货地址</td>
 <td><input type="text"  style="font-size: medium;"name="province" value='<s:property value="order.ad.province"/>'>省 &nbsp;&nbsp;<input type="text" style="font-size: medium;" name="city" value="<s:property value="order.ad.city"/>">市&nbsp;&nbsp;<input type="text" style="font-size: medium;" name="area" value="<s:property value="order.ad.area"/>" >区&nbsp;&nbsp;<input type="text" style="font-size: medium;" name="street" value="<s:property value="order.ad.street"/>">街</td>
 </tr>
 <tr>
 <td colspan="2" align="center"><input type="submit" style="font-size: 20px" value="确认修改"></td>
 </tr>
 </table>
 </form>
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
