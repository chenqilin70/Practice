<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script type="text/javascript">

function userstart(a,b){
	if(b==1){
	var url="UserAction!usercontrol.action?online=0&id="+a;
	$.get(url,function(){
		window.location.href="usercontrol.jsp";
	});	
	}else{
	var url="UserAction!usercontrol.action?online=1&id="+a;
	$.get(url,function(){
		window.location.href="usercontrol.jsp";
	});
	}
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
			<table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
    			<tr align="center" style="font-size: 20px;">
    				<td colspan="9">我可管理的用户</td>
    			</tr>
     			<tr align="center">
			    	<th width="30">编号</th>
			      	<th>用户名</th>
			      	<th>真实姓名</th>
			      	<th>身份</th>
			      	<th>E-mail地址</th>
			      	<th>性别</th>
			      	<th>年龄</th>
			      	<th>启用/禁用</th>
			      	<th>操作</th>
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
          			<td>
          			<s:if test="%{online==1}">
          			<input style="margin-left: 10px;" type="checkbox"  onclick="userstart(<s:property value="userid"/>,<s:property value="online"/>)" id="check<s:property value="userid"/>" checked="true"/>
          			</s:if>
          			<s:else>
          			<input style="margin-left: 10px;" type="checkbox"  onclick="userstart(<s:property value="userid"/>,<s:property value="online"/>)" id="check<s:property value="userid"/>"/>
          			</s:else>
          			</td>
					<td align="center"><a href="UserAction!useredit.action?userid=<s:property value="userid"/>">编辑</a> | <a href="UserAction!userdelete.action?userid=<s:property value="userid"/>">删除</a></td>     			
          		</tr>
     			</s:iterator>
         	</table>
</body>
</html>