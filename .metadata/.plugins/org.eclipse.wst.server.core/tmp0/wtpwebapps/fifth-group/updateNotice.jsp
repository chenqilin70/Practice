<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心 - 更改公告</title>
<script type="text/javascript" src="layer/jquery-3.2.0.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
</head>
<body>
<div id="urHere"> 管理中心<b>></b><strong>更改公告</strong> </div> 
 <div align="center">
    <form method="post" action="NoticeAction!updateNotice.action">
	<table cellspacing="20">
		<tr><td><input type="hidden" value="<s:property value='n.id'/>" name="n.id" /></td></tr>
		<tr><td>公告栏：<textarea  name="n.notice" style="border: 1px gray solid"><s:property  value="n.notice" /></textarea></td></tr>
		<tr><td>荣誉榜：<textarea  name="n.honor" style="border: 1px gray solid"><s:property  value="n.honor" /></textarea></td></tr>
		<tr><td>本月最佳员工：<input value="<s:property value='n.best' />" type="text" name="n.best" style="border: 1px gray solid" /></td></tr>
		<tr><td>发布人：<input value="<s:property value='n.person'/>" type="text" name="n.person" style="border: 1px gray solid" /></td></tr>
		<tr><td><input type="submit" id="closeIframe" /></td></tr>
	</table>
	</form>
 </div>

<script type="text/javascript">
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

$('#closeIframe').click(function(){
    parent.layer.msg('添加成功!!!!');
    parent.layer.close(index);
});
</script>

</body>
</html>