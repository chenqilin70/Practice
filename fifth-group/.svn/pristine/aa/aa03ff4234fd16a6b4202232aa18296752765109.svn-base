<%@page language="java"  pageEncoding="utf-8"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="layer/jquery-3.2.0.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<link rel="stylesheet" href="documents/css/reset.css"/>
    <link rel="stylesheet" href="css/BeatPicker.min.css"/>
    <link rel="stylesheet" href="documents/css/demos.css"/>
    <link rel="stylesheet" href="documents/css/prism.css"/>
   <script src="js/BeatPicker.min.js"></script>
    <script src="documents/js/prism.js"></script>
<style type="text/css">
td{
	height:30px;
	vertical-align: bottom;
}
table{
	position: relative;
	top:-80px;

}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> 管理中心 - 公告管理 </title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript">
	$(function(){
		$(".deleteNotice").click(function deleteNotice(){
			var re=confirm("确定是否删除该公告！");
			if(re){
				window.location.href='NoticeAction!deleteNotice.action?id='+$(this).attr("noticeid");
			}
			return false;
		})
				var mes="<s:property value='%{message}'/>";
				if(mes=='删除成功'||mes=='删除失败')
				alert(mes);
	})

</script>

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
<div id="dcWrap">
<%@include file="Head.jsp" %>

<s:if test="#attr.n==null">
<s:action name="NoticeAction1" namespace="/" >
<s:param name="page">1</s:param>
<s:param name="count">15</s:param>
</s:action>
</s:if>
<div id="dcMain">
<div id="urHere"> 管理中心<b>></b><strong>公告</strong> </div> 
	  <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="#" class="actionBtn add" id="parentIframe" >添加公告</a>公告</h3>
        <h3><a href="NoticeAction!selectNotice.action?date=0" class="actionBtn add" style="position:absolute;top:180px;left:250px">查询今天公告</a></h3>
        <strong>请选择需要查询的时间区间：</strong>
        <input class="dates" type="text" data-beatpicker="true"/>
        <button class="chooseDate" style="padding: 4px;position: relative;left:270px;top:-30px" class="beatpicker-clear beatpicker-clearButton button" type="button">Select</button>
        <h3><a href="NoticeAction!selectNotice.action?date=2" class="actionBtn add" style="position:absolute;top:180px;left:450px">查询近三天公告</a></h3>
        <h3><a href="NoticeAction!selectNotice.action?date=4" class="actionBtn add" style="position:absolute;top:180px;left:650px">查询近五天公告</a></h3>
    <table width="100%" border="0"  cellpadding="8" cellspacing="0" class="tableBasic">
     <tr>
        <th align="left" colspan="4"><font size="4">公告描述</font></th>
       	<th width="100" align="center"><font size="4">日期</font></th>
        <th width="100" align="center"><font size="4">操作</font></th>
      </tr>
      	<tr>
        	<th width="400" align="left">通知栏</th>
       		<th width="60" align="center">荣誉榜</th>
       		<th width="80" align="center">本月最佳员工</th>
       		<th width="80" align="center">发布人</th>
       		<th></th><th></th>
       		</tr>
		<s:iterator  value="#attr.n" status="sta">
		<s:if test="#sta.odd==true">
       	<tr>
       		<td width="650" align="left"><s:a href="#" class="lookNotice" noticeid='${id}'><s:property value="notice"/></s:a></td>
       		<td width="120" align="center"><s:property value="honor" /></td>
       		<td width="100" align="center"><s:property value="best" /></td>
       		<td width="60" align="center"><s:property value="person" /></td>
	        <td align="center"><s:property value="date" /></td>
	        <td align="center"><s:a href="#" class="updateNotice" noticeid='${id}'>编辑</s:a> | 
	        <a href="" class="deleteNotice" noticeid='${id}'>删除</a></td>
       	</tr>
       	</s:if>
       	<s:else>
       		<td style="background-color: #EFEFEF" width="650" align="left"><s:a href="#" class="lookNotice" noticeid='${id}'><s:property value="notice"/></s:a></td>
       		<td style="background-color: #EFEFEF" width="120" align="center"><s:property value="honor" /></td>
       		<td style="background-color: #EFEFEF" width="100" align="center"><s:property value="best" /></td>
       		<td style="background-color: #EFEFEF" width="60" align="center"><s:property value="person" /></td>
	        <td style="background-color: #EFEFEF" align="center"><s:property value="date" /></td>
	        <td style="background-color: #EFEFEF" align="center"><s:a href="#" class="updateNotice" noticeid='${id}'>编辑</s:a> | 
	        <a href="" class="deleteNotice" noticeid='${id}'>删除</a></td>
       	</s:else>
       </s:iterator>    
          </table>
           </div>
 </div>
 <div class="clear"></div>
<div id="dcFooter">
 <div id="footer">
  <div class="line"></div>
  <s:iterator value="#attr.p">
  <div style="text-align: center; margin-bottom: 20px">
			<a style="margin-top: 40px;" class="acount-btn" href="NoticeAction1?page=1&count=12" >首页</a>&nbsp;&nbsp;
			<a style="margin-top: 40px;" class="acount-btn" href="NoticeAction1?page=<s:property value="Prepage"/>&count=12">上一页</a>&nbsp;&nbsp;
			<a style="margin-top: 40px;" class="acount-btn" href="NoticeAction1?page=<s:property value="Nextpage"/>&count=12">下一页</a>&nbsp;&nbsp;
			<a style="margin-top: 40px;" class="acount-btn" href="NoticeAction1?page=<s:property value="Lastpage"/>&count=12">尾页</a>&nbsp;&nbsp;
			<a style="margin-top: 40px;" class="acount-btn">当前第<s:property value="Nowpage"/>页/总共<s:property value="Lastpage"/>页</a> 
		</div>  
  </s:iterator>
  
 </div>
</div><!-- dcFooter 结束 -->
<div class="clear"></div> </div>

<script type="text/javascript">
//弹出一个iframe层  添加通告
$('#parentIframe').on('click', function(){
  layer.open({
  type: 2,
  title: '添加通告',
  maxmin: true,
  shadeClose: true, //点击遮罩关闭层
  area : ['600px' , '450px'],
  content: 'addNotice.jsp',
  end:function(){
	  location.reload();
  }
  
  });
});

//编辑通告
$('.updateNotice').on('click', function(){
	  layer.open({
	  type: 2,
	  title: '更改通告',
	  maxmin: true,
	  shadeClose: true, //点击遮罩关闭层
	  area : ['600px' , '450px'],
	  content: 'NoticeAction!searchNoticeById.action?id='+$(this).attr("noticeid"),
	  end:function(){
		  location.reload();
	  }
	  
	  });
	});
	
//查看通告
$('.lookNotice').on('click', function(){
	  layer.open({
	  type: 2,
	  title: '查看通告',
	  maxmin: true,
	  shadeClose: true, //点击遮罩关闭层
	  area : ['500px' , '350px'],
	  content: 'NoticeAction!lookNoticeById.action?id='+$(this).attr("noticeid"),
	  });
	});
	

//NoticeAction!searchNoticeById.action?id='+{id}

</script>
</body>
</html>