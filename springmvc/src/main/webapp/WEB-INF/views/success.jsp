<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>this is success page</h1>
request name:${requestScope.name }<br>
request age:${requestScope.age }<br>
session name:${sessionScope.name }<br>
session age:${sessionScope.age }<br>
这是中文
<fmt:message key="i18n.username"></fmt:message><br>
<fmt:message key="i18n.password"></fmt:message><br>
</body>
</html>
