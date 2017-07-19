<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="documents/css/reset.css"/>
    <link rel="stylesheet" href="css/BeatPicker.min.css"/>
    <link rel="stylesheet" href="documents/css/demos.css"/>
    <link rel="stylesheet" href="documents/css/prism.css"/>
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/BeatPicker.min.js"></script>
    <script src="documents/js/prism.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="js/jquery.fancybox-1.3.4.js"></script>
    <script type="text/javascript" src="js/jquery.fancybox-1.3.4.pack.js"></script>
    <link rel="stylesheet" href="css/jquery.fancybox-1.3.4.css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心 - 公告管理</title>

<script type="text/javascript">
	$(function(){
		$(".chooseDate").click(function(){
			var d=$(".dates").val();
			window.location.href='NoticeAction!selectAppointNotice.action?dat='+d;
		})
	})
</script>

</head>
<body>
<%@include file="Head.jsp" %>
<div id="dcWrap">
<div id="dcMain">
<div id="urHere"> 管理中心<b>></b><strong>公告</strong> </div> 
	  <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="addNotice.jsp" class="actionBtn add">添加公告</a>公告</h3>
        <h3><a href="NoticeAction!selectNotice.action?date=0" class="actionBtn add" style="position:absolute;top:180px;left:250px">查询今天公告</a></h3>
		<strong>请选择需要查询的时间区间：</strong>
        <input class="dates" type="text" data-beatpicker="true"/>
        <button class="chooseDate" style="padding: 4px;position: relative;left:270px;top:-30px" class="beatpicker-clear beatpicker-clearButton button" type="button">Select</button>
        <h3><a href="NoticeAction!selectNotice.action?date=2" class="actionBtn add" style="position:absolute;top:180px;left:450px">查询近三天公告</a></h3>
        <h3><a href="NoticeAction!selectNotice.action?date=4" class="actionBtn add" style="position:absolute;top:180px;left:650px">查询近五天公告</a></h3>
    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
     <tr>
        <th align="left"><font size="4">公告描述</font></th>
       <th width="60" align="center"><font size="4">日期</font></th>
        <th width="80" align="center"><font size="4">操作</font></th>
      </tr>
	<s:iterator  value="notices">
            <tr>
        <td>
        <table >
        	<tr>
        	<th width="500" align="left">通知栏</th>
       		<th width="60" align="center">荣誉榜</th>
       		<th width="80" align="center">本月最佳员工</th>
       		<th width="80" align="center">发布人</th>
       		</tr>
       		<tr>
       		<td width="650" align="left"><s:property value="notice"/></td>
       		<td width="120" align="center"><s:property value="honor" /></td>
       		<td width="100" align="center"><s:property value="best" /></td>
       		<td width="60" align="center"><s:property value="person" /></td>
       		</tr>
        </table>
        </td>
        <td align="center"><s:property value="date" /></td>
        <td align="center"><s:a href="NoticeAction!searchNoticeById.action?id=%{id}">编辑</s:a> | 
        <a href="" class="deleteNotice" noticeid='${id}'>删除</a></td>
      </tr>
            <tr>
       </s:iterator>    
          </table>
           </div>
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