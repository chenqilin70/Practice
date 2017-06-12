<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/springmvc_crud/emp" method="POST" modelAttribute="employee">
        <c:if test="${requestScope.employee.id ==null}">
            lastName:<form:input path="lastName"/>
        </c:if>
        <c:if test="${requestScope.employee.id !=null}">
            <form:hidden path="id" ></form:hidden>
            <input type="hidden" name="_method" value="PUT">
        </c:if>
        email:<form:input path="email"/>
        department:
        <form:select
                path="department.id"
                itemValue="id"
                items="${depts}"
                itemLabel="departmentName">
        </form:select>
        <%
            Map<Boolean,String> genders=new HashMap<Boolean,String>();
            genders.put(true,"男");
            genders.put(false,"女");
            request.setAttribute("genders",genders);
        %>
        gender：<form:radiobuttons path="gender" items="${genders}"/>
        <input type="submit" value="Submit" />
    </form:form>
    <hr>
</body>
</html>
