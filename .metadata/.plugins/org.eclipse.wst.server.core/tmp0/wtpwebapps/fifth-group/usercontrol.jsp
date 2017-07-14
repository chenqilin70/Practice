<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>杰仔专卖网-用户管理 </title>
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
 
 function xuanze() {
     var my=document.getElementById("xuanze");
     var x=document.getElementsByName("xuan");
     for(var s in x){
         x[s].checked=my.checked;
     }
 }
 
 function dele() {
	    var my=document.getElementById("xuanze");
	    my.checked=false;
	}
 </script>
</head>
<body>
<div id="dcWrap">
<%@include file="Head.jsp" %>
<div id="dcMain">
	<div id="urHere">杰仔专卖网<b>></b><strong>用户管理</strong> </div>   
		<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
		<h3><a href="adduser.jsp" class="actionBtn add">添加用户</a>用户管理</h3>
			<table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
    			<tr align="center" style="font-size: 20px;">
    				<td colspan="9">当前用户</td>
    			</tr>
     			<tr>
			    	<th width="30" align="center">编号</th>
			      	<th align="center">用户名</th>
			      	<th align="center">真实姓名</th>
			      	<th align="center">身份</th>
			      	<th align="center">权限</th>
			      	<th align="center">E-mail地址</th>
			      	<th align="center">性别</th>
			      	<th align="center">年龄</th>
			      	<th align="center"><input onclick="xuanze()" id="xuanze" type="checkbox" style="font-size: 12px;"/>|操作</th>
     			</tr>
          		<tr>
          			<td></td>
          			<td></td>
          			<td></td>
          			<td></td>
          			<td></td>
          			<td></td>
          			<td></td>
          			<td></td>
					<td align="center"><input style="margin-left: 10px;" type="checkbox" onclick="dele()"  name="xuan" /> | <a href="">编辑</a> | <a href="">删除</a></td>     			</tr>
         	</table>


</div>
</div>
<div class="clear"></div>
<div id="dcFooter">
<div id="footer">
<div class="line"></div>
</div>
</div>
<!-- dcFooter 结束 -->
<div class="clear"></div> </div>
</body>
</html>