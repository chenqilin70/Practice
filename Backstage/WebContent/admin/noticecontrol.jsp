<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DouPHP 管理中心 - 文章分类 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
</head>
<body>
<div id="dcWrap">
<%@include file="Head.jsp" %>
<div id="dcMain">
<div id="urHere"> 管理中心<b>></b><strong>公告</strong> </div> 
	  <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="addNotice.jsp" class="actionBtn add">添加公告</a>公告</h3>
    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
     <tr>
        
        <th align="left">公告描述</th>
       <th width="60" align="center">日期</th>
        <th width="80" align="center">操作</th>
      </tr>
            <tr>
        <td>
        <table >
        	<tr>
        	<th width="500" align="left">通知栏</th>
       		<th width="60" align="center">荣誉榜</th>
       		<th width="80" align="center">本月最佳员工</th>
       		</tr>
       		<tr>
       		<td>本周三开会</td>
       		<td>热烈庆祝公司进入全球五百强</td>
       		<td>张卫健成为本月最佳员工奖励奖金10000元</td>
       		</tr>
        </table>
        </td>
        <td align="center">10</td>
        <td align="center"><a href="article_category.php?rec=edit&cat_id=1">编辑</a> | <a href="article_category.php?rec=del&cat_id=1">删除</a></td>
      </tr>
            <tr>
        <td>最新行业资讯</td>
        <td align="center">20</td>
        <td align="center"><a href="article_category.php?rec=edit&cat_id=2">编辑</a> | <a href="article_category.php?rec=del&cat_id=2">删除</a></td>
      </tr>
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