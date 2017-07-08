<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	System.out.println("deal……");
	Thread.sleep(2000);
%>
<h1>This is Index Jsp</h1>
requestMethod:<%=request.getMethod() %>
name:${param.name }<br/>
age:${param.age }<br/>
</body>
</html>