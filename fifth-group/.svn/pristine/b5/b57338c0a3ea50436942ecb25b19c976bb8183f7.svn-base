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
<div id="urHere">DouPHP 管理中心<b>></b><strong>订单列表</strong> </div>   
	<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3>订单列表</h3>
    	<div class="filter">
    <form action="OrderAction!listorder" method="post">
     <select name="cat">
      <option value="0">全部</option>
                  <option value="1" > 已发货</option>
                      <option value="2" > 未发货</option>
                 </select>
     <input type="submit" value="确定">
    </form >
   
    </div>
        <div id="list">
    <form name="action" method="post" action="product.php?rec=action">
    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
      <tr>
        <th width="22" align="center"><input name='chkall' type='checkbox' id='chkall' onclick='selectcheckbox(this.form)' value='check'></th>
        <th width="150" align="center">订单编号</th>
        <th align="left">商品信息</th>
         <th  align="center">商品总价</th>
        <th  align="center">联系电话</th>
       <th  align="center">收货人</th>
        <th align="center">付款时间</th>
        <th width="80" align="center">商品状态</th>
          <th width="80" align="center">操作</th>
      </tr>
       <s:action name="OrderAction!listorder" id="oo" namespace="/" > </s:action>
     <s:iterator value="#attr.ao" > 
      <tr> 
      <td align="center"><input type="checkbox" name="checkbox[]" value="15" /></td>
       <td align="center"><s:property value="oid"/></td>
      <td><s:property value="good.name"/>&nbsp;&nbsp;&nbsp;<s:property value="good.brand"/>&nbsp;&nbsp;<s:property value="good.description"/> <s:property value="prm.count"/>件&nbsp;&nbsp;<s:property value="good.basicprice"/>元 &nbsp;&nbsp;<s:property value="prm.discount"/>折 </td>
     <td align="left"><s:property value="tot"/></td>
     <td align="left"><s:property value="te"/><s:property value="te"/></td>
     <td align="left"><s:property value="pe"/></td>
     <td align="left"><s:property value="ti"/></td>
     <td align="left"><s:property value="st"/></td>
          <td align="left">发货<a> 编辑</td>
     </tr>
     </s:iterator>

        </table>
        
    <div class="action">
     <select name="action" onchange="douAction()">
      <option value="0">请选择...</option>
      <option value="del_all">删除</option>
      <option value="category_move">移动分类至</option>
     </select>
     <select name="new_cat_id" style="display:none">
      <option value="0">未分类</option>
                  <option value="1"> 电子数码</option>
                        <option value="4">- 智能手机</option>
                        <option value="5">- 平板电脑</option>
                        <option value="2"> 家居百货</option>
                        <option value="3"> 母婴用品</option>
                 </select>
     <input name="submit" class="btn" type="submit" value="执行" />
    </div>
    </form>
    </div>
    <div class="clear"></div>
    <div class="pager">总计 15 个记录，共 1 页，当前第 1 页 | <a href="product.php?page=1">第一页</a> 上一页 下一页 <a href="product.php?page=1">最末页</a></div>               </div>
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
