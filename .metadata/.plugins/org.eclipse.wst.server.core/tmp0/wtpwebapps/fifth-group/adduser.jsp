<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>杰仔专卖网-用户管理</title>
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
 
 var tid=1;
 function addtable() {
 	var t="<s:if test='identitylist==null'><s:action name='UserAction!listidentity' id='identitylist' namespace='/' ></s:action></s:if><table id='table"+tid+"' width='100%' border='0' cellpadding='8' cellspacing='0' class='tableBasic'><tr><th width='131'>用户"+tid+"</th><th>内容</th></tr><tr><td align='right'>用户名称</td><td><input type='text' name='users["+tid+"].username' value='' size='80' class='inpMain' /></td></tr><tr><td align='right'>用户密码</td><td><input type='password' name='users["+tid+"].password' value='' size='80' class='inpMain' /></td></tr><tr><td align='right'>真实姓名</td><td><input type='text' name='users["+tid+"].realname' value='' size='80' class='inpMain' /></td></tr><tr><td align='right'>电子邮件</td><td><input type='text' name='users["+tid+"].email' value='' size='80' class='inpMain' /></td></tr><tr><td align='right'>用户职位</td><td><select name='users["+tid+"].position'><s:iterator id='id' value='#identitylist.identitylist' ><option value='<s:property value='#id.position' />'><s:property value='#id.position' /></option></s:iterator></select></td></tr><tr><td align='right'>用户年龄</td><td><select name='users["+tid+"].age'><s:iterator var='i' begin='1' end='100'><option value='${i}'>${i}</option></s:iterator></select></td></tr><tr><td align='right'>用户性别</td><td><label for='rewrite_0'><input type='radio' name='users["+tid+"].sex' id='rewrite_0' value='男' checked='checked'>男</label><label for='rewrite_1'><input type='radio' name='users["+tid+"].sex' id='rewrite_1' value='女'>女</label></td></tr></table>";
	$("#main").append(t);
	tid++;
}
 
 function deletetable() {
	tid--;
	$("#table"+tid+"").remove();
}
 </script>
</head>
<body>
<div id="dcWrap">
<%@include file="Head.jsp" %>
<div id="dcMain">
	<div id="urHere">杰仔专卖网<b>></b><strong>用户管理</strong><b>></b><strong>添加用户</strong> </div>   
		<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
		<h3>添加用户</h3>
		<div class="items">
       		<form action="UserAction!adduser.action" method="post" enctype="multipart/form-data">
        	<div id="main">
        	<s:if test="identitylist==null">
					<s:action name="UserAction!listidentity" id="identitylist" namespace="/" ></s:action>
			</s:if>
					
        	<table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic" id="">
	         	<tr>
	           		<th width="131">用户0</th>
	           		<th>内容</th>
	         	</tr>
	            <tr>
	          		<td align="right">用户名称</td>
	          		<td><input type="text" name="users[0].username" value="" size="80" class="inpMain" /></td>
	         	</tr>
	         	<tr>
	          		<td align="right">用户密码</td>
	          		<td><input type="password" name="users[0].password" value="" size="80" class="inpMain" /></td>
	         	</tr>
	         	<tr>
	          		<td align="right">真实姓名</td>
	          		<td><input type="text" name="users[0].realname" value="" size="80" class="inpMain" /></td>
	         	</tr>
	         	<tr>
	          		<td align="right">电子邮件</td>
	          		<td><input type="text" name="users[0].email" value="" size="80" class="inpMain" /></td>
	         	</tr>
				<tr>
					<td align="right">用户职位</td>
					<td>
					<select name="users[0].position">
					<s:iterator id="id" value="#identitylist.identitylist" >
						<option value="<s:property value="#id.position" />"><s:property value="#id.position" /></option>
					</s:iterator>
					</select></td>
				</tr>
	         	<tr>
	          		<td align="right">用户年龄</td>
	          		<td>
	          		<select name="users[0].age">
	          		<s:iterator var="i" begin="1" end="100">
					<option value="${i}">${i}</option>
	          		</s:iterator>
	          		</select>
	          		</td>
	         	</tr>
				<tr>
	          		<td align="right">用户性别</td>
	          		<td>
                     <label for="rewrite_0">
           			 <input type="radio" name="users[0].sex" id="rewrite_0" value="男" checked="checked">男
           			 </label>
          			 <label for="rewrite_1">
            		 <input type="radio" name="users[0].sex" id="rewrite_1" value="女">女
          			 </label>
                     </td>
	         	</tr>
            </table>
        	</div>
			<table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
	         	<tr>
	          	<td width="57" align="left">
		           	<input class="btn" onclick="addtable()" type="button" value="+" />
	          	</td>
	          	<td width="57" align="right">
		           	<input class="btn" onclick="deletetable()" type="button" value="x" />
	          	</td>
	          	<td>
		           	<input class="btn" type="submit" value="添加" />
	          	</td>
	         	</tr>
       		</table>
      </form>
      </div>

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