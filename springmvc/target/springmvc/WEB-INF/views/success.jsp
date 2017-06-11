<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</body>
</html>
