<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
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
	}</script>
</head>
<body>
			<table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
    			<tr align="center" style="font-size: 20px;">
    				<td colspan="8">我可管理的用户</td>
    			</tr>
     			<tr>
			    	<th width="30" align="center">编号</th>
			      	<th align="center">用户名</th>
			      	<th align="center">真实姓名</th>
			      	<th align="center">身份</th>
			      	<th align="center">E-mail地址</th>
			      	<th align="center">性别</th>
			      	<th align="center">年龄</th>
			      	<th align="center"><input onclick="xuanze()" id="xuanze" type="checkbox" style="font-size: 12px;"/>|操作</th>
     			</tr>
          		<s:iterator value="controlusers">
          		<tr align="center">
     				<td><s:property value="userid"/></td>
          			<td><s:property value="username"/></td>
          			<td><s:property value="realname"/></td>
          			<td><s:property value="position"/></td>
          			<td><s:property value="email"/></td>
          			<td><s:property value="sex"/></td>
          			<td><s:property value="age"/></td>
					<td align="center"><input style="margin-left: 10px;" type="checkbox" onclick="dele()"  name="xuan" /> | <a href="">编辑</a> | <a href="">删除</a></td>     			
          		</tr>
     			</s:iterator>
         	</table>
</body>
</html>