<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理中心 - 编写公告</title>
<script type="text/javascript" src="layer/jquery-3.2.0.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript" src="js/validfrom.js"></script>
<style type="text/css">
span{
    color:red;
    font-family:'华文行楷';
    
    
}
</style>
</head>
<body>
<div id="dcMain">
<div id="urHere"> 管理中心<b>></b><strong>公告</strong><b>></b><strong>编写公告</strong> </div> 
<br/>

<form class="add" method="post" action="NoticeAction!addNotice.action">
	<div align="left">
	<table cellspacing="20">
		<tr><td>  <label class="label">公告栏：</label>
<textarea datatype="*" errormsg="请输入公告内容！！" id="noti" name="n.notice" style="border: 1px gray solid"></textarea></td></tr>
		<tr><td>荣誉榜：<textarea datatype="*"  id="hono" name="n.honor" style="border: 1px gray solid"></textarea></td></tr>
		<tr><td>本月最佳员工：<input sucmsg="厉害厉害!!" datatype="*"  id="bes" type="text" name="n.best" style="border: 1px gray solid" /></td></tr>
		<tr><td>发布人：<input datatype="*" type="text" name="n.person" readonly="readonly" value="${sessionScope.user.realname}" style="border: 1px gray solid" /></td></tr>
		<tr><td><input type="submit" id="closeIframe" /></td></tr>
	</table>
	</div>
</form>
</div>

<script type="text/javascript">
$(function(){
$(".add").Validform({
	tiptype:3,
	postonce:true,
});
	
});

var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

$('#closeIframe').click(function(){
    parent.layer.msg('添加成功!!!!');
    parent.layer.close(index);
});
</script>



</body>
</html>