<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DouPHP 管理中心 - 订单分页列表 </title>
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
<div id="urHere">
<!--  <button type="button" style="margin-left: 800px; border-style:none;width:124px; height:35px; background-repeat:no-repeat;" >分页查询</button> -->
<a href="ordercontrol.jsp"><img src="images\fanhui.png" style="margin-left: 90%;width:120px;height: 80px"></a>
</div>   
	<div class="mainBox" style="height:550px;min-height:550px;">
        <h3>订单分页列表</h3>
    	<div class="filter">
    
    </div>
    
     <div id="list">
   
    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic" style="font-size: medium;">
      <tr>
      <th width="22" align="center"><input name='chkall' type='checkbox' id='chkall' onclick='selectcheckbox(this.form)' value='check'></th>
        <th width="150" align="center">订单编号</th>
        <th align="left">商品信息</th>
         <th  align="center">商品总价</th>
<!--         <th  align="center">联系电话</th> -->
<!--        <th  align="center">收货人</th> -->
        <th align="center">付款时间</th>
        <th width="80" align="center">商品状态</th>
          <th width="80" align="center">操作</th>
      </tr>
      <s:if test="ap==null">
      <s:action name="OrderAction!listorderbypage" namespace="/">
      <s:param name="pg.page"><s:if test="pg==null"> 1</s:if></s:param>
      <s:param name="pg.value"><s:if test="pg==null">5</s:if></s:param>
      </s:action>
      </s:if>
      <s:iterator value="#attr.ap"> 
      <tr> 
      <td align="center"><input type="checkbox" name="box" value='<s:property value="oid"/>' /></td>
       <td align="center" name="oid"><s:property value="oid"/></td>
      <td><a href="OrderAction!listOrderbyoid?oid=<s:property value="oid"/>"><s:property value="good.name"/></a></td>
     <td align="left"><s:property value="tot"/></td>
<%--       <td align="left"><s:property value="pe"/></td> --%>
     <td align="left"><s:property value="ti"/></td>
     <td align="left"><s:if test="st==0">已发货</s:if> <s:if test="st==1">未发货</s:if></td>
          <td align="left"><s:if test="st==0">已发货</s:if><s:if test="st==1"><a href="OrderAction!sendOrder?oid=<s:property value="oid"/>">发货</a></s:if></td>
     </tr>
     </s:iterator>
        </table>
        
       
        
   
   
   <div style="text-align: center; margin-bottom: 20px">
   <s:iterator value="#attr.pg">
				<a href="OrderAction!listorderbypage?pg.page=<s:property value='firstpage'/>&pg.value=5" ><font style="font-size: medium;">首页</font></a>
				<font style="font-size: medium;">当前第</font><font style="color:red;font-size: medium;"><s:property value='nowpage'/></font></font><font style="font-size: medium;">页</font>
				<a href="OrderAction!listorderbypage?pg.page=<s:property value='prexpage' />&pg.value=5" ><font style="font-size: medium;">上一页</font></a>
				<a href="OrderAction!listorderbypage?pg.page=<s:property value='nextpage' />&pg.value=5" ><font style="font-size: medium;">下一页</font></a>
				<font style="font-size: medium;">总共</font><font style="color:red;font-size: medium;"><s:property value='lastpage'/></font><font style="font-size: medium;">页</font>
				<a href="OrderAction!listorderbypage?pg.page=<s:property value='lastpage' />&pg.value=5" ><font style="font-size: medium;">尾页</font></a>
			</s:iterator>
   </div>
   
<div id="dcFooter">
 <div id="footer">
  <div class="line"></div>
 </div>
</div><!-- dcFooter 结束 -->
<div class="clear"></div> </div>
</body>
</html>
