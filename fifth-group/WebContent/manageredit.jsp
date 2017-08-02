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
 
 
 </script>
</head>
<body>
<div id="dcWrap">
<%@include file="Head.jsp" %>
<div id="dcMain">
	<div id="urHere">杰仔专卖网<b>></b><strong>网站管理员</strong><b>></b><strong>管理员修改</strong> </div>   
		<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
		<h3>管理员修改</h3>
		<div class="items">
       		<form action="UserAction!updatemanager.action" method="post" enctype="multipart/form-data">
        	<div id="main">
        	
        	<s:if test="identitylist==null">
					<s:action name="UserAction!listidentity" id="identitylist" namespace="/" ></s:action>
			</s:if>
			<input type="hidden" name="user.userid" value='<s:property value="user.userid"  />'>
        	<table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
	         	<tr>
	           		<th width="90">名称</th>
	           		<th colspan="2">内容</th>
	         	</tr>
	            <tr>
	          		<td align="right">用户名称</td>
	          		<td colspan="2"><input type="text" readonly="readonly" name="user.username" value='<s:property value="user.username" />' size="80" class="inpMain" /></td>
	         	</tr>
	         	<tr>
	          		<td align="right">用户密码</td>
	          		<td colspan="2"><input type="password" name="user.password" value='<s:property value="user.password" />' size="80" class="inpMain" /></td>
	         	</tr>
	         	
	         	<tr>
	          		<td align="right">真实姓名</td>
	          		<td colspan="2"><input type="text" name="user.realname" value='<s:property value="user.realname" />' size="80" class="inpMain" /></td>
	         	</tr>
	         	<tr>
	          		<td align="right">电子邮件</td>
	          		<td colspan="2"><input type="text" name="user.email" value='<s:property value="user.email" />' size="80" class="inpMain" /></td>
	         	</tr>
				<tr>
					<td align="right">用户职位</td>
					<td colspan="2">
					<select name="user.position">
						<option  selected="selected" value='<s:property value="user.position" />'><s:property value="user.position" /></option>
					</select></td>
				</tr>
	         	<tr>
	          		<td align="right">用户年龄</td>
	          		<td colspan="2">
	          		<select name="user.age" autocomplete="off">
	          		<s:iterator var="i" begin="1" end="100">
	          			<s:if test="user.age==#i">
						<option selected="selected" value="${i}">${i}</option>
	          			</s:if>
	          			<s:else>
						<option  value="${i}">${i}</option>
	          			</s:else>
	          		</s:iterator>
	          		</select>
	          		</td>
	         	</tr>
				<tr>
	          		<td align="right">用户性别</td>
	          		<td colspan="2">
	          		<s:if test='user.sex=="男"'>
                     <label for="rewrite_0">
           			 <input type="radio" name="user.sex" id="rewrite_0" value="男" checked="checked">男
           			 </label>
          			 <label for="rewrite_1">
            		 <input type="radio" name="user.sex" id="rewrite_1" value="女">女
          			 </label>
	          		</s:if>
	          		<s:if test='user.sex=="女"'>
                     <label for="rewrite_0">
           			 <input type="radio" name="user.sex" id="rewrite_0" value="男" >男
           			 </label>
          			 <label for="rewrite_1">
            		 <input type="radio" name="user.sex" id="rewrite_1" value="女" checked="checked">女
          			 </label>
	          		</s:if>
	          		
            </table>
        	</div>
			<table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
	         	<tr>
	         	<td width="90"></td>
	          	<td>
		           	<input class="btn" type="submit" value="更改" />
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