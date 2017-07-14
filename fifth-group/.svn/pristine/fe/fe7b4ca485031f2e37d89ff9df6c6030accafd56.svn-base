<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心 - 公告管理</title>
</head>
<body>
<%@include file="Head.jsp" %>
<div id="dcWrap">
<div id="dcMain">
<div id="urHere"> 管理中心<b>></b><strong>公告</strong> </div> 
	  <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="addNotice.jsp" class="actionBtn add">添加公告</a>公告</h3>
        <h3><a href="NoticeAction!selectNotice.action?date=0" class="actionBtn add" style="position:absolute;top:180px;left:250px">查询今天公告</a></h3>
        <h3><a href="NoticeAction!selectNotice.action?date=2" class="actionBtn add" style="position:absolute;top:180px;left:450px">查询近三天公告</a></h3>
        <h3><a href="NoticeAction!selectNotice.action?date=4" class="actionBtn add" style="position:absolute;top:180px;left:650px">查询近五天公告</a></h3>
    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
     <tr>
        
        <th align="left">公告描述</th>
       <th width="60" align="center">日期</th>
        <th width="80" align="center">操作</th>
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